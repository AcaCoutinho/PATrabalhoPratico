package pt.isec.pa.apoio_poe.model.data;

import java.util.ArrayList;

public class Candidatura {
    private long n_aluno;
    private ArrayList<String> idPropostas;

    public Candidatura(long n_aluno) {
        idPropostas = new ArrayList<>();
        this.n_aluno = n_aluno;
    }

    public ArrayList<String> getIdPropostas(){
        ArrayList<String> tmp = new ArrayList<>(idPropostas);
        return tmp;
    }

    public void adicionaId(ArrayList<String> idPropostas) {
        this.idPropostas.addAll(idPropostas);
    }

    public long getN_aluno(){
        return n_aluno;
    }

    @Override
    public String toString() {
        return null;
    }
}
