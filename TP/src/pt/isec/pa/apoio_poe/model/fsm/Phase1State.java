package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.utils.PAInput;

import javax.print.Doc;
import java.util.ArrayList;

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
        if(obj instanceof Estagio){
            Estagio aux = (Estagio) obj;
            phase.adicionaProposta(aux);
        }
        if(obj instanceof Projeto) {
            Projeto aux = (Projeto) obj;
            if(phase.procuraDocente(aux.getProponente().getEmail()) == null){
                System.out.println("Docente não encontrado");
            }
            phase.adicionaProposta(aux);
        }
        if(obj instanceof Autoproposto){
            Autoproposto aux = (Autoproposto) obj;
            phase.adicionaProposta(aux);
        }
    }

    @Override
    public String consult(ArrayList<String> a){
        if(a.contains("student")){
            long n_aluno = Long.parseLong(a.get(1));
            if(phase.procuraAluno(n_aluno) != null){
                return phase.procuraAluno(n_aluno).toString();
            }
        }
        if(a.contains("docente")){
            if(phase.procuraDocente(a.get(1)) != null){
                return phase.procuraDocente(a.get(1)).toString();
            }
        }
        if(a.contains("proposta")){
            if(phase.procuraProposta(a.get(1)) != null){
                return phase.procuraProposta(a.get(1)).toString();
            }
        }
        return null;
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
