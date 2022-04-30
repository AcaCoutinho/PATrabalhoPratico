package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

import java.util.ArrayList;

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
    public void insert(String tipo, String fileName){

    }

    @Override
    public String consult(ArrayList<String> a){
        return null;
    }

    @Override
    public void edit(){

    }

    @Override
    public void remove(){

    }

    @Override
    public void assignment(int tipo){

    }

    @Override
    public String lista(ArrayList<String> al) {
        return null;
    }

    @Override
    public boolean previousPhase(){
        return false;
    }

    @Override
    public void closePhase(){

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
