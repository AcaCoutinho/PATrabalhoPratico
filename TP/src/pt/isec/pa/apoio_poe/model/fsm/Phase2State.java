package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        StringBuilder sb = new StringBuilder();
        Aluno aux1;
        if(al.contains("student")) {
            if (al.get(1).equals("autoproposta")) {
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        aux1 = phase.procuraAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                }
                return sb.toString();
            }
            if (al.get(1).equals("candidatura")) {
                for(int i = 0; i < phase.getCandidaturas().size(); i++){
                    aux1 = phase.procuraAluno(phase.getCandidaturas().get(i).getN_aluno());
                    sb.append(aux1.toString());
                }

                return sb.toString();
            }
            if (al.get(1).equals("no_candidatura")) {


                //Ainda falta fazer este


            }
            return sb.toString();
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
                for(int i = 0; i < phase.getPropostas().size(); i++){
                    if(phase.getPropostas().get(i) instanceof Autoproposto aux){
                        sb.append(aux.toString());
                    }
                    if(phase.getPropostas().get(i) instanceof Projeto aux){
                        if(aux.getN_alunoAt() != 0){
                            sb.append(aux.toString());
                        }
                    }
                    if(phase.getPropostas().get(i) instanceof Estagio aux){
                        if(aux.getN_alunoAt() != 0){
                            sb.append(aux.toString());
                        }
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("no_candidatura")){


                //Ainda falta fazer este


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
