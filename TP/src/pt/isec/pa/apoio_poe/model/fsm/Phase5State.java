package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

public class Phase5State extends PhaseStateAdapter{
    protected Phase5State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public boolean previousPhase() {
        return false;
    }
    @Override
    public boolean nextPhase() {
        return false;
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_5;
    }
}
