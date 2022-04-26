package pt.isec.pa.apoio_poe.model.data;

public class Autoproposto extends Proposta{
    private long n_alunoPro;

    public Autoproposto(String titulo, long n_alunoPro){
        super(titulo);
        this.n_alunoPro = n_alunoPro;
    }

    public String getCa(){
        return super.getCa();
    }

    public String getTitulo(){
        return super.getTitulo();
    }
    public void setTitulo(String titulo){
        super.setTitulo(titulo);
    }

    public long getN_alunoPro(){
        return n_alunoPro;
    }
    public void setN_alunoPro(long n_alunoPro){
        this.n_alunoPro = n_alunoPro;
    }
}
