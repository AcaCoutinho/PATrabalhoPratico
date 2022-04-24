package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

abstract class PhaseStateAdapter implements IPhaseState{
    protected Phase phase;
    protected PhaseContext context;

    PhaseStateAdapter(Phase phase, PhaseContext context) {
        this.phase = phase;
        this.context = context;
    }

    @Override
    public void insert(){

    }

    @Override
    public void consult(){

    }

    @Override
    public void edit(){

    }

    @Override
    public void remove(){

    }

    @Override
    public boolean previousPhase(){
        return false;
    }

    @Override
    public boolean closePhase(){
        return false;
    }

    @Override
    public boolean nextPhase(){
        return false;
    }

    @Override
    public PhaseState getPhaseState() {
        return null;
    }

}
