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


}
