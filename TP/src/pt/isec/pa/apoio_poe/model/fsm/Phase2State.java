package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Phase;

import java.util.ArrayList;

public class Phase2State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase2State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void insert(String tipo, String fileName) {

    }

    @Override
    public String consult(ArrayList<String> a) {
        long n_aluno = Long.parseLong(a.get(0));

        if(phase.procuraCandidatura(n_aluno) != null) {
            return phase.procuraCandidatura(n_aluno).toString();
        }
        return null;
    }

    @Override
    public String lista(ArrayList<String> al) {
    if(al.contains("student")) {
        if (al.get(1).equals("autoproposta")) {

        }
        if (al.get(1).equals("candidatura")) {

        }
        if (al.get(1).equals("no_candidatura")) {

        }
    }
        if(al.contains("proposta")){
            if(al.get(1).equals("autoproposta")){

            }
            if(al.get(1).equals("docente")){

            }
            if(al.get(1).equals("candidatura")){

            }
            if(al.get(1).equals("no_candidatura")){

            }
        }
        return null;
    }

    @Override
    public void closePhase() {
        isClosed = true;
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
