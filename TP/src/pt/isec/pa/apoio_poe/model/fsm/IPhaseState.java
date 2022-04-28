package pt.isec.pa.apoio_poe.model.fsm;

import java.util.ArrayList;

public interface IPhaseState {

    void insert(String tipo);
    String consult(ArrayList<String> a);
    void edit();
    void remove();

    boolean previousPhase();
    void closePhase();
    boolean nextPhase();

    PhaseState getPhaseState();
}
