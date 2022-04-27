package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.utils.PAInput;

import javax.print.Doc;

public class Phase1State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase1State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void insert(Object obj){
        if(obj instanceof Aluno) {
            Aluno aux = (Aluno) obj;
            phase.adicionaAluno(aux);
        }
        if(obj instanceof Docente) {
            Docente aux = (Docente) obj;
            phase.adicionaDocente(aux);
        }
        if(obj instanceof Proposta) {

        }
    }

    @Override
    public void consult(Object obj){
        if (obj instanceof Aluno) {
            Aluno aux = (Aluno) obj;

            phase.procuraAluno(aux);
        }
    }

    @Override
    public void edit(Object obj){

    }

    @Override
    public void remove(Object obj){

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
}
