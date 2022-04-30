package pt.isec.pa.apoio_poe.model.data;

public abstract class Proposta {
    private String ca;
    private String titulo;
    private long n_alunoAt;

    Proposta(String ca, String titulo, long n_alunoAt){
        this.ca = ca;
        this.titulo = titulo;
        this.n_alunoAt = n_alunoAt;
    }

    String getCa(){
        return ca;
    }

    String getTitulo(){
        return titulo;
    }
    void setTitulo(String titulo){
        this.titulo = titulo;
    }

    long getN_alunoAt() { return n_alunoAt; }
    void setN_alunoAt(long n_alunoAt) { this.n_alunoAt = n_alunoAt; }
}
