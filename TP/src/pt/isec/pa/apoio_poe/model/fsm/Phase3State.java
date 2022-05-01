package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import javax.sound.sampled.spi.AudioFileReader;
import javax.swing.*;
import java.security.AuthProvider;
import java.util.ArrayList;
import java.util.HashMap;

public class Phase3State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase3State(Phase phase, PhaseContext context) {
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
                    phase.procuraAluno(propostas.get(i)).setPropAtribuida(phase.procuraProposta(i));
                }
            }
            phase.mostraAlunos();
        }else{
            HashMap<String, Long> propostas = phase.getPropAndAlunos();

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
                        aux1 = phase.procuraAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("candidatura")){
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    aux1 = phase.procuraAluno(phase.getCandidaturas().get(i).getN_aluno());
                    sb.append(aux1.toString());
                }
                return sb.toString();
            }
            if(al.get(1).equals("atribuida")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        aux1 = phase.procuraAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                    if(phase.getPropostas().get(i) instanceof Estagio aux){
                        if(aux.getN_alunoAt() != 0){
                            aux1 = phase.procuraAluno(aux.getN_alunoAt());
                            sb.append(aux1.toString());
                        }
                    }
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        if(aux.getN_alunoAt() != 0){
                            aux1 = phase.procuraAluno(aux.getN_alunoAt());
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
