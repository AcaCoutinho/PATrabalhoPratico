package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.utils.PAInput;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Phase1State extends PhaseStateAdapter{
    private boolean isClosed;
    protected Phase1State(Phase phase, PhaseContext context) {
        super(phase, context);
        isClosed = false;
    }

    @Override
    public void insert(String tipo, String fileName) {
        if(tipo.equals("student")){
            ArrayList<String> dados = new ArrayList<>();
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
                phase.adicionaAluno(new Aluno(Long.parseLong(dados.get(i++)), dados.get(i++), dados.get(i++), dados.get(i++), dados.get(i++), Double.parseDouble(dados.get(i++)), Boolean.parseBoolean(dados.get(i++))));
            }
        }
        if(tipo.equals("docente")){
            ArrayList<String> dados = new ArrayList<>();
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
            System.out.println(dados.size());
            while(i < dados.size()){
                phase.adicionaDocente(new Docente(dados.get(i++), dados.get(i++)));
            }

        }
        if(tipo.equals("proposta")){

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
    }
}
