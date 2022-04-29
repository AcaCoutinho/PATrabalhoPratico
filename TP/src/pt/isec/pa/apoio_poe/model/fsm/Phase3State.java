package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

import java.util.ArrayList;

public class Phase3State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase3State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
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
