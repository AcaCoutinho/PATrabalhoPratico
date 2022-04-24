package pt.isec.pa.apoio_poe.model.fsm;

public interface IPhaseState {

    void insert();
    void consult();
    void edit();
    void remove();



    boolean previousPhase();
    boolean closePhase();
    boolean nextPhase();

    PhaseState getPhaseState();
}
