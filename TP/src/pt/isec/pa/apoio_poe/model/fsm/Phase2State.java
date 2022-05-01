package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Phase2State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase2State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void insert(String tipo, String fileName) {
        ArrayList<String> dados = new ArrayList<>();
        long n_aluno;
        ArrayList<String> idPropostas = new ArrayList<>();
        Candidatura aux;

        try{
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);
            sc.useDelimiter(",|\\n");

            while(sc.hasNext()){
                dados.add(sc.next());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        int i = 0;
        while(i < dados.size()) {
            n_aluno = Long.parseLong(dados.get(i++));
            while(dados.get(i).contains("P")){
                idPropostas.add(dados.get(i).trim());
                if(i+1 == dados.size()){
                    i++;
                    break;
                }else{
                    i++;
                }
            }
            aux = new Candidatura(n_aluno);
            aux.adicionaId(idPropostas);
            phase.adicionaCandidatura(aux);
            idPropostas.clear();
        }

        phase.associaAlunoCandidatura();
        phase.mostraAlunosCandidaturas();
    }

    @Override
    public String consult(ArrayList<String> a) {
        long n_aluno = Long.parseLong(a.get(0));

        if(phase.procuraCandidatura(n_aluno) != null) {
            return phase.procuraCandidatura(n_aluno).toString();
        }
        return null;
    }

    @Override
    public String lista(ArrayList<String> al) {
        StringBuilder sb = new StringBuilder();
        Aluno aux1;
        if(al.contains("student")) {
            if (al.get(1).equals("autoproposta")) {
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        aux1 = phase.procuraAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                }
                return sb.toString();
            }
            if (al.get(1).equals("candidatura")) {
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    aux1 = phase.procuraAluno(phase.getCandidaturas().get(i).getN_aluno());
                    sb.append(aux1.toString());
                }

                return sb.toString();
            }
            if (al.get(1).equals("no_candidatura")) {
                ArrayList<Long> n_alunos = new ArrayList<>();
                for(int i = 0; i < phase.getCandidaturas().size(); i++){

                }
            }
        }
        if(al.contains("proposta")){
            if(al.get(1).equals("autoproposta")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
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
            if(al.get(1).equals("candidatura")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        sb.append(aux.toString());
                    }
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        if(aux.getN_alunoAt() != 0){
                            sb.append(aux.toString());
                        }
                    }
                    if(phase.getPropostas().get(i) instanceof Estagio aux){
                        if(aux.getN_alunoAt() != 0){
                            sb.append(aux.toString());
                        }
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("no_candidatura")){
                ArrayList<String> ids = new ArrayList<>();
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    ids.addAll(phase.getCandidaturas().get(i).getIdPropostas());
                }
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    for(int j = 0; j < ids.size(); j++){
                        if(phase.procuraProposta(ids.get(j)).equals(phase.getPropostas().get(i))){

                        }
                    }
                }
                return sb.toString();
            }
        }
        return null;
    }

    @Override
    public void closePhase() {
        isClosed = true;
        nextPhase();
    }

    @Override
    public boolean nextPhase(){
        return(changePhaseState(PhaseState.PHASE_3));
    }

    @Override
    public boolean previousPhase() {
        return(changePhaseState(PhaseState.PHASE_1));
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_2;
    }
}
