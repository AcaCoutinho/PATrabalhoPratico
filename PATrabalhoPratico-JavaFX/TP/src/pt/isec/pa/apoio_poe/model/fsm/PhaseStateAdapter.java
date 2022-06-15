package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.io.IOException;
import java.util.ArrayList;

public abstract class PhaseStateAdapter implements IPhaseState{
    protected Phase phase;
    protected PhaseContext context;
    protected boolean status;

    protected PhaseStateAdapter(Phase phase, PhaseContext context) {
        this.phase = phase;
        this.context = context;
    }

    final protected boolean changePhaseState(PhaseState state){
        context.changeState(state.createState(context, phase));
        return true;
    }

    @Override
    public boolean getIsClosed(int phase) {
        return false;
    }

    @Override
    public void setIsClosed(int phase, boolean isClosed){

    }

    @Override
    public void insertAluno(Aluno aluno) {

    }
    @Override
    public void insertAlunoFile(String fileName) {

    }
    @Override
    public void insertDocente(Docente docente){

    }
    @Override
    public void insertDocenteFile(String fileName){

    }
    @Override
    public void insertProposta(Proposta proposta){

    }
    @Override
    public void insertPropostaFile(String fileName){

    }
    @Override
    public void insertCandidatura(Candidatura candidatura){

    }
    @Override
    public void insertCandidaturaFile(String fileName){

    }

    @Override
    public String consultAluno(long nAluno){
        return null;
    }
    @Override
    public String consultDocente(String a){
        return null;
    }
    @Override
    public String consultProposta(String a){
        return null;
    }
    @Override
    public String consultCandidatura(long nAluno){
        return null;
    }

    @Override
    public void editAluno(long nAluno){

    }
    @Override
    public void editDocente(String a){

    }
    @Override
    public void editProposta(String a){

    }
    @Override
    public void editCandidatura(long nAluno){

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
    public void removeCandidatura(long nAluno){

    }

    @Override
    public void assignment(int tipo){

    }

    @Override
    public void export(String fileName) {

    }

    @Override
    public String listaAluno(String tipoLista) {
        return null;
    }
    @Override
    public String listaDocente(String tipoLista) {
        return null;
    }
    @Override
    public String listaProposta(String tipoLista) {
        return null;
    }

    @Override
    public boolean previousPhase(){
        return false;
    }

    @Override
    public void closePhase(){

    }

    @Override
    public boolean nextPhase(){
        return false;
    }

    @Override
    public PhaseState getPhaseState() {
        return null;
    }

}
