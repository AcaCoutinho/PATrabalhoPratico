package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

public enum PhaseState {
    PHASE_1, PHASE_2, PHASE_3, PHASE_4, PHASE_5;

    public IPhaseState createState(PhaseContext context, Phase phase) {
        return switch (this) {
            case PHASE_1 -> new Phase1State(phase, context);
            case PHASE_2 -> new Phase2State(phase, context);
            case PHASE_3 -> new Phase3State(phase, context);
            case PHASE_4 -> new Phase4State(phase, context);
            case PHASE_5 -> new Phase5State(phase, context);
        };
    }
}
