package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseStateAdapter;

import java.util.ArrayList;

public class Phase4State extends PhaseStateAdapter {
    public Phase4State(Phase phase, PhaseContext context) {
        super(phase, context);
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
                            System.out.println("\nDebug1\n");
                            phase.getDocente(j.getEmail()).setOrientador(true);
                            phase.getDocente(j.getEmail()).setProjeto(aux);
                            System.out.println("\nDebug2\n");
                        }
                    }
                }
            }
        }
    }

    @Override
    public String listaAluno(String tipoLista) {
        return phase.listaAluno(tipoLista);
    }

    @Override
    public String listaDocente(String tipoLista) {
        return phase.listaDocente(tipoLista);
    }

    public void export(String fileName) {
        phase.export(fileName);
    }

    @Override
    public void closePhase() {
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
