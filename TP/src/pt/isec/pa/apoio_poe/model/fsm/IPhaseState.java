package pt.isec.pa.apoio_poe.model.fsm;

public interface IPhaseState {

    void insert(int i);
    void consult(int i);
    void edit(int i);
    void remove(int i);

    boolean previousPhase();
    boolean closePhase();
    boolean nextPhase();

    PhaseState getPhaseState();
}
