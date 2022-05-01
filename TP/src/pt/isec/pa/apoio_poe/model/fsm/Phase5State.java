package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.util.ArrayList;

public class Phase5State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase5State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public String lista(ArrayList<String> al) {
        StringBuilder sb = new StringBuilder();
        Aluno aux1;
        if(al.contains("student")){
            if(al.get(1).equals("atribuidas")){
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
            if(al.get(1).equals("candidatura")){
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    aux1 = phase.procuraAluno(phase.getCandidaturas().get(i).getN_aluno());
                    sb.append(aux1.toString());
                }
                return sb.toString();
            }
        }
        if(al.contains("docente")){
            sb.append("Em média, um docente orienta " + phase.getMediaOrientadores() + " projetos.\n");
            for(int i = 0; i < phase.getDocentes().size(); i++){
                sb.append(phase.getDocentes().get(i).toString());
            }
            return sb.toString();
        }
        if(al.contains("proposta")){
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
                        if(aux.getN_alunoAt() != 0){
                            sb.append(aux.toString());
                        }
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
    public boolean previousPhase() {
        return false;
    }
    @Override
    public boolean nextPhase() {
        return false;
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_5;
    }
}
