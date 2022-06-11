package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.states.Phase1State;

public class PhaseContext {
    private Phase phase;
    private IPhaseState state;

    public PhaseContext() {
        phase = new Phase();
        state = new Phase1State(phase, this);
    }

    public PhaseState getState() {
        return state.getPhaseState();
    }

    public void changeState(IPhaseState newState) {
        state = newState;
    }

    public void insertAluno(Aluno aluno) {
        state.insertAluno(aluno);
    }
    public void insertAlunoFile(String fileName) {
        state.insertAlunoFile(fileName);
    }
    public void insertDocente(Docente docente) {
        state.insertDocente(docente);
    }

    public void insertDocenteFile(String fileName) {
        state.insertDocenteFile(fileName);
    }
    public void insertProposta(Proposta proposta) {
        state.insertProposta(proposta);
    }
    public void insertPropostaFile(String fileName) {
        state.insertPropostaFile(fileName);
    }
    public void insertCandidatura(Candidatura candidatura) {
        state.insertCandidatura(candidatura);
    }
    public void insertCandidaturaFile(String fileName) {
        state.insertCandidaturaFile(fileName);
    }

    public String consultAluno(long nAluno) {
        return state.consultAluno(nAluno);
    }
    public String consultDocente(String a){
        return state.consultDocente(a);
    }
    public String consultProposta(String a) {
        return state.consultProposta(a);
    }
    public String consultCandidatura(long nAluno) {
        return state.consultCandidatura(nAluno);
    }

    public void editAluno(long nAluno) {
        state.editAluno(nAluno);
    }
    public void editDocente(String a) {
        state.editDocente(a);
    }
    public void editProposta(String a) {
        state.editProposta(a);
    }
    public void editCandidatura(long nAluno) {
        state.editCandidatura(nAluno);
    }

    public void removeAluno(long nAluno) {
        state.removeAluno(nAluno);
    }
    public void removeDocente(String a) {
        state.removeDocente(a);
    }
    public void removeProposta(String a) {
        state.removeProposta(a);
    }
    public void removeCandidatura(long nAluno) {
        state.removeCandidatura(nAluno);
    }

    public void assignment(int tipo){
        state.assignment(tipo);
    }

    public void export(String fileName) {
        state.export(fileName);
    }

    public String listaAluno(String tipoLista) {
        return state.listaAluno(tipoLista);
    }
    public String listaDocente(String tipoLista) {
        return state.listaDocente(tipoLista);
    }
    public String listaProposta(String tipoLista) {
        return state.listaProposta(tipoLista);
    }

    public boolean previousPhase() {
        return state.previousPhase();
    }

    public void closeState() {
        state.closePhase();
    }

    public boolean nextPhase() {
        return state.nextPhase();
    }
}
