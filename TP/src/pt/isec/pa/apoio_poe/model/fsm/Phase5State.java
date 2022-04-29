package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

import java.util.ArrayList;

public class Phase5State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase5State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public String lista(ArrayList<String> al) {
        if(al.contains("student")){
            if(){

            }
            if(){

            }
        }
        if(al.contains("docente")){

        }
        if(al.contains("proposta")){

        }
        return null;
    }

    @Override
    public void closePhase() {
        isClosed = true;
        nextPhase();
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
