package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

public class Phase4State extends PhaseStateAdapter{
    protected Phase4State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_4;
    }
}
