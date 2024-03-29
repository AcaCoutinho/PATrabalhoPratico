package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public interface IPhaseState {
    boolean getIsClosed(int phase);
    void setIsClosed(int phase, boolean isClosed);

    void insertAluno(Aluno aluno);
    void insertAlunoFile(String fileName);
    void insertDocente(Docente docente);
    void insertDocenteFile(String fileName);
    void insertProposta(Proposta proposta);
    void insertPropostaFile(String fileName);
    void insertCandidatura(Candidatura candidatura);
    void insertCandidaturaFile(String fileName);

    String consultAluno(long nAluno);
    String consultDocente(String a);
    String consultProposta(String a);
    String consultCandidatura(long nAluno);

    void editAluno(long nAluno, String tipo, String dados);
    void editDocente(String email, String tipo, String dados);
    void editProposta(String ca, String tipo, String dados);
    void editCandidatura(long nAluno, String tipo, ArrayList<String> dados);

    void removeAluno(long nAluno);
    void removeDocente(String a);
    void removeProposta(String a);
    void removeCandidatura(long nAluno);

    void assignment(int tipo);
    void export(String fileName);

    String listaAluno(String tipoLista);
    String listaDocente(String tipoLista);
    String listaProposta(String tipoLista);

    boolean previousPhase();
    void closePhase();
    boolean nextPhase();

    PhaseState getPhaseState();
}
