package pt.isec.pa.apoio_poe.model.data;

import javax.print.Doc;
import java.util.ArrayList;

public class Phase {
    private ArrayList<Aluno> alunos;
    private ArrayList<Docente> docentes;
    private ArrayList<Proposta> propostas;
    private ArrayList<Candidatura> candidaturas;

    public Phase() {
        alunos = new ArrayList<>();
        docentes = new ArrayList<>();
        propostas = new ArrayList<>();
        candidaturas = new ArrayList<>();
    }

    public boolean adicionaAluno(Aluno aluno){
        if(alunos.contains(aluno)){
            return false;
        }else{
            alunos.add(aluno);
            return true;
        }
    }

    public Aluno procuraAluno(long n_aluno){
        for(var i : alunos){
            if(i.getN_aluno() == n_aluno){
                return i;
            }
        }
        return null;
    }

    public boolean removeAluno(long n_aluno){
        for(var i : alunos){
            if(i.getN_aluno() == n_aluno){
                alunos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void mostraAlunos(){
        for(var i : alunos){
            System.out.println(i.toString());
        }
    }

    public boolean adicionaDocente(Docente docente){
        if(docentes.contains(docente)){
            return false;
        }else{
            docentes.add(docente);
            return true;
        }
    }

    public Docente procuraDocente(String email){
        for(var i : docentes){
            if(i.getEmail().equals(email)){
                return i;
            }
        }
        return null;
    }

    public boolean removeDocente(String email){
        for(var i : docentes){
            if(i.getEmail().equals(email)){
                docentes.remove(i);
                return true;
            }
        }
        return false;
    }

    public void mostraDocentes(){
        for(var i : docentes){
            System.out.println(i.toString());
        }
    }

    public boolean adicionaProposta(Proposta proposta){
        if(propostas.contains(proposta)){
            return false;
        }else{
            propostas.add(proposta);
            return true;
        }
    }

    public Proposta procuraProposta(String ca){
        for(var i : propostas){
            if(i.getCa().equals(ca)){
                return i;
            }
        }
        return null;
    }

    public boolean removeProposta(String ca){
        for(var i : propostas){
            if(i.getCa().equals(ca)){
                propostas.remove(i);
                return true;
            }
        }
        return false;
    }

    public void mostraPropostas(){
        for(var i : propostas){
            System.out.println(i.toString());
        }
    }

    public boolean adicionaCandidatura(Candidatura candidatura) {
        if(candidaturas.contains(candidatura)) {
            return false;
        } else {
            candidaturas.add(candidatura);
            return true;
        }
    }

    public Candidatura procuraCandidatura(long n_aluno) {
        for (var i : candidaturas){
            if(i.getN_aluno() == n_aluno)
                return i;
        }
        return null;
    }

    public boolean removeCandidatura(long n_aluno) {
        for (var i : candidaturas){
            if(i.getN_aluno() == n_aluno)
                candidaturas.remove(i);
                return true;
        }
        return false;
    }
}
