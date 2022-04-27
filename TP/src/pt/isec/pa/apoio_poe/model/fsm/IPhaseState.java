package pt.isec.pa.apoio_poe.model.fsm;

public interface IPhaseState {

    void insert(Object obj);
    void consult(Object obj);
    void edit(Object obj);
    void remove(Object obj);

    boolean previousPhase();
    void closePhase();
    boolean nextPhase();

    PhaseState getPhaseState();
}
