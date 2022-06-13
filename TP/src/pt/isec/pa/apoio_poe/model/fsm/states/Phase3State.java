package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseStateAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class Phase3State extends PhaseStateAdapter {
    public Phase3State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public void assignment(int tipo){
        if(tipo == 0){
            HashMap<String, Long> propostas = phase.getPropAndAlunos();
            System.out.println(propostas);
            for(var i : propostas.keySet()){
                if(propostas.get(i) != 0){
                    phase.getAluno(propostas.get(i)).setPropAtribuida(phase.getProposta(i));
                }
            }
        } else {
            ArrayList<Aluno> alunosSem = phase.getAlunos();
            ArrayList<Proposta> propostasSem = phase.getPropostas();
            ArrayList<Candidatura> candidaturas = phase.getCandidaturas();
            HashMap<String, Long> propostas = phase.getPropAndAlunos();
            for(var i : propostas.keySet()){
                if(propostas.get(i) != 0){
                    alunosSem.remove(phase.getAluno(propostas.get(i)));
                    propostasSem.remove(phase.getProposta(i));
                }
            }
            ciclo: for(var i : alunosSem){
                boolean access = i.getAccess();
                for(var k : candidaturas){
                    if(k.getN_aluno() == i.getN_aluno()){
                        for(var j : k.getIdPropostas()){
                            if(propostasSem.contains(phase.getProposta(j))){
                                if(phase.getProposta(j) instanceof Estagio){
                                    if(access){
                                        System.out.println("Entrei1");
                                        phase.getAluno(i.getN_aluno()).setPropAtribuida(phase.getProposta(j));
                                        phase.getProposta(j).setN_alunoAt(i.getN_aluno());
                                        continue ciclo;
                                    }else{
                                        System.out.println("Entrei2");
                                        continue;
                                    }
                                }
                                phase.getAluno(i.getN_aluno()).setPropAtribuida(phase.getProposta(j));
                                phase.getProposta(j).setN_alunoAt(i.getN_aluno());
                            }
                        }
                    }
                }
                propostasSem.remove(i.getPropAtribuida());
            }
            alunosSem.clear();
        }
    }

    @Override
    public String listaAluno(String tipoLista) {
        return phase.listaAluno(tipoLista);
    }

    @Override
    public String listaProposta(String tipoLista) {
        return phase.listaProposta(tipoLista);
    }

    @Override
    public void export(String fileName){
        phase.export(fileName);
    }

    @Override
    public void closePhase() {
        phase.setIsClosed(3, true);
        nextPhase();
    }

    @Override
    public boolean nextPhase(){
        return(changePhaseState(PhaseState.PHASE_4));
    }

    @Override
    public boolean previousPhase() {
        if(phase.getisClosed(2))
            return false;
        return(changePhaseState(PhaseState.PHASE_2));
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_3;
    }
}
