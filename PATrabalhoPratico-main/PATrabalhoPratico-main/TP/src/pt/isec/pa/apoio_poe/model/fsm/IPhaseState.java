package pt.isec.pa.apoio_poe.model.fsm;

public interface IPhaseState {

    void insert();
    void consult();
    void edit();
    void remove();



    void previousPhase();
    void closePhase();
    void nextPhase();

    PhaseState getPhaseState();
}
