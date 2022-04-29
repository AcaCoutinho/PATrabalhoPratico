package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

abstract class PhaseStateAdapter implements IPhaseState{
    protected Phase phase;
    protected PhaseContext context;
    protected boolean status;

    PhaseStateAdapter(Phase phase, PhaseContext context) {
        this.phase = phase;
        this.context = context;
    }

    final protected boolean changePhaseState(PhaseState state){
        context.changeState(state.createState(context, phase));
        return true;
    }

    @Override
    public void insert(int i){

    }

    @Override
    public void consult(int i){

    }

    @Override
    public void edit(int i){

    }

    @Override
    public void remove(int i){

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
