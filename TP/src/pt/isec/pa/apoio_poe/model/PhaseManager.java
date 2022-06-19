package pt.isec.pa.apoio_poe.model;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PhaseManager {
    private PhaseContext fsm;
    PropertyChangeSupport pcs;

    public PhaseManager() {
        fsm = new PhaseContext();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public PhaseState getPhaseState() {
        return fsm.getState();
    }

    public boolean nextPhase() {
        var ret = fsm.nextPhase();
        pcs.firePropertyChange(null, null, null);
        return ret;
    }

    public boolean getIsClosed(int phase){ return fsm.getIsClosed(phase); }

    public void closePhase() {
        fsm.closeState();
        pcs.firePropertyChange(null, null, null);
    }

    public boolean previousPhase() {
        var ret = fsm.previousPhase();
        pcs.firePropertyChange(null, null, null);
        return ret;
    }

    public void insertAluno(Aluno aluno) {
        fsm.insertAluno(aluno);
    }
    public void insertAlunoFile(String fileName) {
        fsm.insertAlunoFile(fileName);
    }
    public void insertDocente(Docente docente) { fsm.insertDocente(docente); }
    public void insertDocenteFile(String fileName) {
        fsm.insertDocenteFile(fileName);
    }
    public void insertProposta(Proposta proposta) {
        fsm.insertProposta(proposta);
    }
    public void insertPropostaFile(String fileName) {
        fsm.insertPropostaFile(fileName);
    }
    public void insertCandidatura(Candidatura candidatura) {
        fsm.insertCandidatura(candidatura);
    }
    public void insertCandidaturaFile(String fileName) {
        fsm.insertCandidaturaFile(fileName);
    }

    public String consultAluno(long nAluno) {
        return fsm.consultAluno(nAluno);
    }
    public String consultDocente(String a){
        return fsm.consultDocente(a);
    }
    public String consultProposta(String a) {
        return fsm.consultProposta(a);
    }
    public String consultCandidatura(long nAluno) {
        return fsm.consultCandidatura(nAluno);
    }

    public void editAluno(long nAluno, String tipo, String dados) {
        fsm.editAluno(nAluno, tipo, dados);
    }
    public void editDocente(String email, String tipo, String dados) {
        fsm.editDocente(email, tipo, dados);
    }
    public void editProposta(String ca, String tipo, String dados) {
        fsm.editProposta(ca, tipo, dados);
    }
    public void editCandidatura(long nAluno, String tipo, ArrayList<String> dados) { fsm.editCandidatura(nAluno, tipo, dados); }

    public void removeAluno(long nAluno) {
        fsm.removeAluno(nAluno);
    }
    public void removeDocente(String a) {
        fsm.removeDocente(a);
    }
    public void removeProposta(String a) {
        fsm.removeProposta(a);
    }
    public void removeCandidatura(long nAluno) {
        fsm.removeCandidatura(nAluno);
    }

    public void assignment(int tipo){
        fsm.assignment(tipo);
    }

    public void export(String fileName) {
        fsm.export(fileName);
    }

    public String listaAluno(String tipoLista) {
        return fsm.listaAluno(tipoLista);
    }
    public String listaDocente(String tipoLista) {
        return fsm.listaDocente(tipoLista);
    }
    public String listaProposta(String tipoLista) {
        return fsm.listaProposta(tipoLista);
    }

    public Aluno getAluno(long nAluno){ return fsm.getAluno(nAluno); }
    public Docente getDocente(String email){ return fsm.getDocente(email); }
    public Proposta getProposta(String ca){ return fsm.getProposta(ca); }
}
