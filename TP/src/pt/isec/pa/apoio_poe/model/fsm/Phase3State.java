package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

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

                //Falta fazer

            }
            if(al.get(1).equals("no")){

                //Falta fazer

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
