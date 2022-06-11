package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseStateAdapter;

public class Phase2State extends PhaseStateAdapter {
    public Phase2State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public void insertCandidatura(Candidatura candidatura){
        phase.adicionaCandidatura(candidatura);
    }

    @Override
    public void insertCandidaturaFile(String fileName){
        phase.adicionaCandidaturaFile(fileName);
    }

    @Override
    public String consultCandidatura(long nAluno){
        return phase.getCandidatura(nAluno).toString();
    }

    @Override
    public void editCandidatura(long nAluno){
        if(phase.procuraCandidatura(nAluno)){
            phase.editCandidatura();
        }
    }

    @Override
    public void removeCandidatura(long nAluno){
        phase.removeCandidatura(nAluno);
    }

    @Override
    public String listaAluno(String tipoLista) {
        return phase.listaAluno(tipoLista);
    }
    @Override
    public String listaProposta(String tipoLista) {
        return phase.listaProposta(tipoLista);
    }

    @Override
    public void closePhase() {
        nextPhase();
    }

    @Override
    public boolean nextPhase(){
        return(changePhaseState(PhaseState.PHASE_3));
    }

    @Override
    public boolean previousPhase() {
        return(changePhaseState(PhaseState.PHASE_1));
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_2;
    }
}
