package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Phase;
import pt.isec.pa.apoio_poe.model.data.Projeto;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class Phase4State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase4State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void assignment(int tipo){
        if(tipo == 0){
            ArrayList<Proposta> propostas = phase.getPropostas();
            ArrayList<Docente> docentes = phase.getDocentes();
            for(var i : propostas){
                if(i instanceof Projeto aux){
                    for(var j : docentes){
                        if(j == aux.getProponente()){
                            phase.procuraDocente(j.getEmail()).setOrientador(true);
                            phase.procuraDocente(j.getEmail()).setProjeto(aux);
                        }
                    }
                }
            }
            phase.mostraDocentes();
        }
    }

    @Override
    public String lista(ArrayList<String> al) {
        StringBuilder sb = new StringBuilder();
        if(al.contains("student")) {
            if(al.get(1).equals("associado")){

            }
            if(al.get(1).equals("no_associado")){

            }
        }
        if(al.contains("docente")){

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
        return(changePhaseState(PhaseState.PHASE_5));
    }

    @Override
    public boolean previousPhase() {
        return(changePhaseState(PhaseState.PHASE_3));
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_4;
    }
}
