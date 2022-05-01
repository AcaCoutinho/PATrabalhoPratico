package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
                            System.out.println("\nDebug1\n");
                            phase.procuraDocente(j.getEmail()).setOrientador(true);
                            phase.procuraDocente(j.getEmail()).setProjeto(aux);
                            System.out.println("\nDebug2\n");
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
        Aluno aux1;
        Proposta aux;
        if(al.contains("student")) {
            if(al.get(1).equals("associado")){
                for(int i = 0; i < phase.getDocentes().size(); i++){
                    if(phase.getDocentes().get(i).getOrientador()){
                        aux = phase.getDocentes().get(i).getProjeto();
                        aux1 = phase.procuraAluno(aux.getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                }
                return sb.toString();
            }
            if(al.get(1).equals("no_associado")){
                ArrayList<String> idsDocente = new ArrayList<>();
                ArrayList<String> ids = new ArrayList<>();
                for(int i = 0; i < phase.getDocentes().size(); i++){
                    if(phase.getDocentes().get(i).getOrientador()){
                        idsDocente.add(phase.getDocentes().get(i).getProjeto().getCa());
                    }
                }

                for(int i = 0; i < phase.getPropostas().size(); i++){
                    ids.add(phase.getPropostas().get(i).getCa());
                }

                ids.removeAll(idsDocente);
                for(int i  = 0; i < ids.size(); i++){
                    if(phase.procuraProposta(ids.get(i)).getN_alunoAt() != 0){
                        aux1 = phase.procuraAluno(phase.procuraProposta(ids.get(i)).getN_alunoAt());
                        sb.append(aux1.toString());
                    }
                }
                return sb.toString();
            }
        }
        if(al.contains("docente")){
            sb.append("Em média, um docente orienta " + phase.getMediaOrientadores() + "projetos.\n");
            for (int i = 0; i < phase.getDocentes().size(); i++){
                sb.append(phase.getDocentes().get(i).toString());
            }
            return sb.toString();
        }
        return null;
    }

    public void export(String fileName) throws IOException {
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter br = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(br);

            ArrayList<Aluno> alunos = phase.getAlunos();

            for(int i = 0; i < alunos.size(); i++){
                pw.append(alunos.get(i).getNome() + "," + alunos.get(i).getN_aluno() + "," + alunos.get(i).getEmail()+","
                        + alunos.get(i).getSiglaC()+ "," + alunos.get(i).getSiglaR() + "," + alunos.get(i).getGrade());
                if(alunos.get(i).getPropAtribuida() != null){
                    pw.append("," + alunos.get(i).getPropAtribuida().getCa());
                }
                pw.append("\n");
            }
            pw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
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
