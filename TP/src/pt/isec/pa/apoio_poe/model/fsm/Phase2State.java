package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

public class Phase2State extends PhaseStateAdapter{
    protected Phase2State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_2;
    }
}
