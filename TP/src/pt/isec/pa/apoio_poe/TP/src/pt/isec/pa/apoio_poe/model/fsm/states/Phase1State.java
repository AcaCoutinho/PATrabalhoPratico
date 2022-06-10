package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseStateAdapter;
import pt.isec.pa.apoio_poe.utils.PAInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Phase1State extends PhaseStateAdapter {
    private boolean isClosed;
    public Phase1State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void insertAluno(Aluno aluno) {
        phase.adicionaAluno(aluno);
    }

    @Override
    public void insertAlunoFile(String fileName) {
        phase.adicionaAlunoFile(fileName);
    }

    @Override
    public void insertDocente(Docente docente) {
        phase.adicionaDocente(docente);
    }

    @Override
    public void insertDocenteFile(String fileName) {
        phase.adicionaDocenteFile(fileName);
    }

    @Override
    public void insertProposta(Proposta proposta) {
        phase.adicionaProposta(proposta);
    }

    @Override
    public void insertPropostaFile(String fileName) {
        phase.adicionaPropostaFile(fileName);
    }

    @Override
    public String consultAluno(long nAluno) {
        return phase.getAluno(nAluno).toString();
    }

    @Override
    public String consultDocente(String email) {
        return phase.getDocente(email).toString();
    }

    @Override
    public String consultProposta(String ca){
        return phase.getProposta(ca).toString();
    }

    @Override
    public void editAluno(long nAluno){
        if(phase.procuraAluno(nAluno)){
            //phase.editAluno();
        }
    }

    @Override
    public void editDocente(String a) {

    }

    @Override
    public void editProposta(String a) {

    }

    @Override
    public void removeAluno(long nAluno){

    }

    @Override
    public void removeDocente(String a){

    }

    @Override
    public void removeProposta(String a){

    }


    @Override
    public void closePhase() {
        isClosed = true;
        nextPhase();
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

    public boolean isClosed() {
        return isClosed;
    }
}
