package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseStateAdapter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Phase3State extends PhaseStateAdapter {
    private boolean isClosed;
    public Phase3State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void assignment(int tipo){
        if(tipo == 0){
            HashMap<String, Long> propostas = phase.getPropAndAlunos();
            System.out.println(propostas);
            for(var i : propostas.keySet()){
                if(propostas.get(i) != 0){
                    phase.getAluno(propostas.get(i)).setPropAtribuida(phase.getProposta(i));
                }
            }
        }else{
            ArrayList<Aluno> alunosSem = phase.getAlunos();
            ArrayList<Proposta> propostasSem = phase.getPropostas();
            ArrayList<Candidatura> candidaturas = phase.getCandidaturas();
            HashMap<String, Long> propostas = phase.getPropAndAlunos();
            for(var i : propostas.keySet()){
                if(propostas.get(i) != 0){
                    alunosSem.remove(phase.getAluno(propostas.get(i)));
                    propostasSem.remove(phase.getProposta(i));
                }
            }
            ciclo: for(var i : alunosSem){
                boolean access = i.getAccess();
                for(var k : candidaturas){
                    if(k.getN_aluno() == i.getN_aluno()){
                        for(var j : k.getIdPropostas()){
                            if(propostasSem.contains(phase.getProposta(j))){
                                if(phase.getProposta(j) instanceof Estagio){
                                    if(access){
                                        System.out.println("Entrei1");
                                        phase.getAluno(i.getN_aluno()).setPropAtribuida(phase.getProposta(j));
                                        phase.getProposta(j).setN_alunoAt(i.getN_aluno());
                                        continue ciclo;
                                    }else{
                                        System.out.println("Entrei2");
                                        continue;
                                    }
                                }
                                phase.getAluno(i.getN_aluno()).setPropAtribuida(phase.getProposta(j));
                                phase.getProposta(j).setN_alunoAt(i.getN_aluno());
                            }
                        }
                    }
                }
                propostasSem.remove(i.getPropAtribuida());
            }
            alunosSem.clear();
        }
    }

    @Override
    public String lista(ArrayList<String> al) {
        StringBuilder sb = new StringBuilder();
        Aluno aux1;
        if(al.contains("student")){
            if(al.get(1).equals("autoproposta")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        aux1 = phase.getAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("candidatura")){
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    aux1 = phase.getAluno(phase.getCandidaturas().get(i).getN_aluno());
                    sb.append(aux1.toString());
                }
                return sb.toString();
            }
            if(al.get(1).equals("atribuida")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        aux1 = phase.getAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                    if(phase.getPropostas().get(i) instanceof Estagio aux){
                        if(aux.getN_alunoAt() != 0){
                            aux1 = phase.getAluno(aux.getN_alunoAt());
                            sb.append(aux1.toString());
                        }
                    }
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        if(aux.getN_alunoAt() != 0){
                            aux1 = phase.getAluno(aux.getN_alunoAt());
                            sb.append(aux1.toString());
                        }
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("no")){
                ArrayList<Long> n_alunosAtribuida = new ArrayList<>();
                ArrayList<Long> n_alunos = new ArrayList<>();

                for(int i = 0; i < phase.getAlunos().size(); i++){
                    n_alunos.add(phase.getAlunos().get(i).getN_aluno());
                }
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    n_alunosAtribuida.add(phase.getPropostas().get(i).getN_alunoAt());
                }

                n_alunos.removeAll(n_alunosAtribuida);
                for(int i = 0; i < n_alunos.size(); i++){
                    sb.append(phase.procuraAluno(n_alunos.get(i)));
                }
                return sb.toString();
            }
        }
        if(al.contains("proposta")){
            if(al.get(1).equals("autoproposta")){
                for(int i = 0; i < phase.getPropostas().size(); i++) {
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        sb.append(aux.toString());
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("docente")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        sb.append(aux.toString());
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("disponiveis")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Estagio aux){
                        if(aux.getN_alunoAt() == 0){
                            sb.append(aux.toString());
                        }
                    }
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        if(aux.getN_alunoAt() == 0){
                            sb.append(aux.toString());
                        }
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("atribuidas")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        sb.append(aux.toString());
                    }
                    if(phase.getPropostas().get(i) instanceof Estagio aux){
                        if(aux.getN_alunoAt() != 0){
                            sb.append(aux.toString());
                        }
                    }
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        if(aux.getN_alunoAt() != 0){
                            sb.append(aux.toString());
                        }
                    }
                }
                return sb.toString();
            }
        }
        return null;
    }

    @Override
    public void export(String fileName) throws IOException {
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter br = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(br);

            ArrayList<Aluno> alunos = phase.getAlunos();

            for(int i = 0; i < alunos.size(); i++){
                pw.append(alunos.get(i).getNome() + "," + alunos.get(i).getN_aluno() + "," + alunos.get(i).getEmail()+","
                        + alunos.get(i).getSiglaC()+ "," + alunos.get(i).getSiglaR() + "," + alunos.get(i).getGrade());
                if(alunos.get(i).getPropAtribuida() != null){
                    pw.append("," + alunos.get(i).getPropAtribuida().getCa());
                }
                pw.append("\n");
            }
            pw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void closePhase() {
        isClosed = true;
        nextPhase();
    }

    @Override
    public boolean nextPhase(){
        return(changePhaseState(PhaseState.PHASE_4));
    }

    @Override
    public boolean previousPhase() {
        return(changePhaseState(PhaseState.PHASE_2));
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_3;
    }
}
