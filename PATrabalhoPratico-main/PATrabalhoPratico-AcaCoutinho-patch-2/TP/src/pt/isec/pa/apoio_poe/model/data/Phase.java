package pt.isec.pa.apoio_poe.model.data;

import javax.print.Doc;
import java.util.ArrayList;

public class Phase {
    private ArrayList<Aluno> alunos;
    private ArrayList<Docente> docentes;
    private ArrayList<Proposta> propostas;

    public Phase() {
        alunos = new ArrayList<>();
        docentes = new ArrayList<>();
        propostas = new ArrayList<>();
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
            if(i.getEmail() == email){
                return i;
            }
        }
        return null;
    }

    public boolean removeDocente(String email){
        for(var i : docentes){
            if(i.getEmail() == email){
                docentes.remove(i);
                return true;
            }
        }
        return false;
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
            if(i.getCa() == ca){
                return i;
            }
        }
        return null;
    }

    public boolean removeProposta(String ca){
        for(var i : propostas){
            if(i.getCa() == ca){
                propostas.remove(i);
                return true;
            }
        }
        return false;
    }
}
