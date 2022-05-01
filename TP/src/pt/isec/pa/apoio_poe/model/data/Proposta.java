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

    public String getCa(){
        return ca;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public long getN_alunoAt() { return n_alunoAt; }
    public void setN_alunoAt(long n_alunoAt) { this.n_alunoAt = n_alunoAt; }
}
