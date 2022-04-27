package pt.isec.pa.apoio_poe.model.fsm;

import java.util.ArrayList;

public interface IPhaseState {

    void insert(Object obj);
    String consult(ArrayList<String> a);
    void edit(Object obj);
    void remove(Object obj);

    boolean previousPhase();
    void closePhase();
    boolean nextPhase();

    PhaseState getPhaseState();
}
