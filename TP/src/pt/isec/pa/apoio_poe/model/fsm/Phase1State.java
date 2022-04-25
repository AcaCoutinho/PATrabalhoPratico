package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Phase;
import pt.isec.pa.apoio_poe.utils.PAInput;

public class Phase1State extends PhaseStateAdapter{
    protected Phase1State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public boolean nextPhase(){
        return(changePhaseState(PhaseState.PHASE_2));
    }

    @Override
    public boolean previousPhase() {
        return false;
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_1;
    }
}
