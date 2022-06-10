package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseStateAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Phase2State extends PhaseStateAdapter {
    private boolean isClosed;
    public Phase2State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void insertCandidatura(Candidatura candidatura){
        phase.adicionaCandidatura(candidatura);
    }

    @Override
    public void insertCandidaturaFile(String fileName){
        phase.adicionaCandidaturaFile(fileName);
    }

    @Override
    public String consultCandidatura(long nAluno){
        return phase.getCandidatura(nAluno).toString();
    }

    @Override
    public void editCandidatura(long nAluno){
        if(phase.procuraCandidatura(nAluno)){
            phase.editCandidatura();
        }
    }

    @Override
    public void removeCandidatura(long nAluno){
        phase.removeCandidatura(nAluno);
    }

    @Override
    public String lista(ArrayList<String> al) {
        StringBuilder sb = new StringBuilder();
        Aluno aux1;
        if(al.contains("student")) {
            if (al.get(1).equals("autoproposta")) {
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        aux1 = phase.getAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                }
                return sb.toString();
            }
            if (al.get(1).equals("candidatura")) {
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    aux1 = phase.getAluno(phase.getCandidaturas().get(i).getN_aluno());
                    sb.append(aux1.toString());
                }
                return sb.toString();
            }
            if (al.get(1).equals("no_candidatura")) {
                ArrayList<Long> n_alunosCandidaturas = new ArrayList<>();
                ArrayList<Long> n_alunos = new ArrayList<>();
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    n_alunosCandidaturas.add(phase.getCandidaturas().get(i).getN_aluno());
                }

                for(int i = 0; i < phase.getAlunos().size(); i++){
                    n_alunos.add(phase.getAlunos().get(i).getN_aluno());
                }

                n_alunos.removeAll(n_alunosCandidaturas);
                for(int i = 0; i < n_alunos.size(); i++){
                    sb.append(phase.procuraAluno(n_alunos.get(i)));
                }
                return sb.toString();
            }
        }
        if(al.contains("proposta")){
            if(al.get(1).equals("autoproposta")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        sb.append(aux.toString());
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("docente")){
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        sb.append(aux.toString());
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("candidatura")){
                ArrayList<String> idsCandidatura = new ArrayList<>();
                ArrayList<String> idsPropostas = new ArrayList<>();

                for(int i = 0; i < phase.getPropostas().size(); i++){
                    idsPropostas.add(phase.getPropostas().get(i).getCa());
                }

                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    idsCandidatura.addAll(phase.getCandidaturas().get(i).getIdPropostas());
                }

                idsPropostas.removeAll(idsCandidatura);
                for(int i = 0; i < idsPropostas.size(); i++){
                    sb.append(phase.procuraProposta(idsPropostas.get(i)));
                }
                return sb.toString();

            }
            if(al.get(1).equals("no_candidatura")){
                ArrayList<String> idsCandidatura = new ArrayList<>();
                ArrayList<String> idsPropostas = new ArrayList<>();
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    idsCandidatura.addAll(phase.getCandidaturas().get(i).getIdPropostas());
                }

                for(int i = 0; i < phase.getPropostas().size(); i++){
                    idsPropostas.add(phase.getPropostas().get(i).getCa());
                }

                idsPropostas.removeAll(idsCandidatura);
                for(int i = 0; i < idsPropostas.size(); i++){
                    sb.append(phase.procuraProposta(idsPropostas.get(i)));
                }
                return sb.toString();
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
