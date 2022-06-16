package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.utils.PAInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Phase1State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase1State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    /*@Override
    public void insert(String tipo, String fileName) {
        ArrayList<String> dados = new ArrayList<>();
        if(tipo.equals("student")){
            try{
                File f = new File(fileName);
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                Scanner sc = new Scanner(br);
                sc.useDelimiter(",|\\n");

                while(sc.hasNext()){
                    dados.add(sc.next());
                }

            } catch (IOException e){
                e.printStackTrace();
            }

            int i = 0;
            while(i < dados.size()){
                phase.adicionaAluno(new Aluno(Long.parseLong(dados.get(i++)), dados.get(i++), dados.get(i++), dados.get(i++), dados.get(i++), Double.parseDouble(dados.get(i++)), Boolean.parseBoolean(dados.get(i++).trim())));
            }
            //phase.mostraAlunos();
        }
        if(tipo.equals("docente")){
            try{
                File f = new File(fileName);
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                Scanner sc = new Scanner(br);
                sc.useDelimiter(",|\\n");

                while(sc.hasNext()){
                    dados.add(sc.next());
                }

            } catch (IOException e){
                e.printStackTrace();
            }

            int i = 0;
            while(i < dados.size()){
                phase.adicionaDocente(new Docente(dados.get(i++), dados.get(i++).trim()));
            }
            //phase.mostraDocentes();
        }
        if(tipo.equals("proposta")){
            try{
                File f = new File(fileName);
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                Scanner sc = new Scanner(br);
                sc.useDelimiter(",|\\n");

                while(sc.hasNext()){
                    dados.add(sc.next());
                }

            } catch (IOException e){
                e.printStackTrace();
            }
            int i = 0;
            while(i < dados.size()){
                if(dados.get(i).equals("T1")){
                    i++;
                    if(i >= dados.size()-4 || dados.get(i+4).equals("T1") || dados.get(i+4).equals("T2")  || dados.get(i+4).equals("T3")){
                        phase.adicionaProposta(new Estagio(dados.get(i++), dados.get(i++), dados.get(i++), dados.get(i++).trim()));
                    }else{
                        phase.adicionaProposta(new Estagio(dados.get(i++), dados.get(i++), dados.get(i++), dados.get(i++), Long.parseLong(dados.get(i++).trim())));
                    }
                }else if(dados.get(i).equals("T2")){
                    i++;
                    if(i >= dados.size()-4 || dados.get(i+4).equals("T1") || dados.get(i+4).equals("T2") || dados.get(i+4).equals("T3")){
                        phase.adicionaProposta(new Projeto(dados.get(i++), dados.get(i++), dados.get(i++), phase.procuraDocente(dados.get(i++).trim())));
                    }else{
                        phase.adicionaProposta(new Projeto(dados.get(i++), dados.get(i++), dados.get(i++), phase.procuraDocente(dados.get(i++)), Long.parseLong(dados.get(i++).trim())));
                    }
                }else{
                    i++;
                    phase.adicionaProposta(new Autoproposto(dados.get(i++), dados.get(i++), Long.parseLong(dados.get(i++).trim())));
                }
            }
            //phase.mostraPropostas();
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
    public void edit(){

    }

    @Override
    public void remove(){

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
    }*/
}
