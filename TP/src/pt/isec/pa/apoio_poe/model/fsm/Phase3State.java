package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Phase;
import pt.isec.pa.apoio_poe.model.data.Proposta;

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
        if(al.contains("student")){
            if(al.get(1).equals("autoproposta")){

            }
            if(al.get(1).equals("docente")){

            }
            if(al.get(1).equals("atribuida")){

            }
            if(al.get(1).equals("no")){

            }
        }
        if(al.contains("proposta")){
            if(al.get(1).equals("autoproposta")){

            }
            if(al.get(1).equals("docente")){

            }
            if(al.get(1).equals("disponiveis")){

            }
            if(al.get(1).equals("atribuidas")){

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
