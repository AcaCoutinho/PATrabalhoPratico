package pt.isec.pa.apoio_poe.model.fsm;

import java.io.IOException;
import java.util.ArrayList;

public interface IPhaseState {

    void insert(String tipo, String fileName);
    String consult(ArrayList<String> a);
    void edit();
    void remove();
    void assignment(int tipo);
    void export(String fileName) throws IOException;

    String lista(ArrayList<String> al);

    boolean previousPhase();
    void closePhase();
    boolean nextPhase();

    PhaseState getPhaseState();
}
