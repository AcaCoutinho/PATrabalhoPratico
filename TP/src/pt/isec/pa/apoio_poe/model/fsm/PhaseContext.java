package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

import java.util.ArrayList;

public class PhaseContext {
    private Phase phase;
    private IPhaseState state;

    public PhaseContext() {
        phase = new Phase();
        state = new Phase1State(phase, this);
    }

    public PhaseState getState() {
        return state.getPhaseState();
    }

    public void changeState(IPhaseState newState) {
        state = newState;
    }

    //TODO: Fazer resto das funcoes da Interface
    public void insert(Object aux){
        state.insert(aux);
    }

    public String consult(ArrayList<String> a){
        return state.consult(a);
    }

    public void edit(Object aux){
        state.edit(aux);
    }

    public void remove(Object aux){
        state.remove(aux);
    }

    public boolean previousPhase() {
        return state.previousPhase();
    }

    public void closeState() {
        state.closePhase();
    }

    public boolean nextPhase() {
        return state.nextPhase();
    }

}
