package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

public class Phase4State extends PhaseStateAdapter{
    protected Phase4State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public boolean nextPhase(){
        return(changePhaseState(PhaseState.PHASE_5));
    }

    @Override
    public boolean previousPhase() {
        return(changePhaseState(PhaseState.PHASE_3));
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_4;
    }
}
