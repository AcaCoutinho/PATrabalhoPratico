package pt.isec.pa.apoio_poe.model.fsm;

abstract class PhaseStateAdapter implements IPhaseState{
    PhaseStateAdapter() {
        super();
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
    public void previousPhase(){

    }

    @Override
    public void closePhase(){

    }

    @Override
    public void nextPhase(){

    }

    @Override
    public PhaseState getPhaseState() {
        return null;
    }

}
