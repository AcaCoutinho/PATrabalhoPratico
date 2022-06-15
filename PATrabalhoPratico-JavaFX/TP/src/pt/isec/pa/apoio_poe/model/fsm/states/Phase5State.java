package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseStateAdapter;

public class Phase5State extends PhaseStateAdapter {
    public Phase5State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public String listaAluno(String tipoLista) {
        return phase.listaAluno(tipoLista);
    }
    @Override
    public String listaDocente(String tipoLista) {
        return phase.listaDocente(tipoLista);
    }
    @Override
    public String listaProposta(String tipoLista) {
        return phase.listaProposta(tipoLista);
    }

    public void export(String fileName) {
        phase.export(fileName);
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
