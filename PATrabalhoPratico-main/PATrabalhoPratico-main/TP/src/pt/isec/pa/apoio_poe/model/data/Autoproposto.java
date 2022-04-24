package pt.isec.pa.apoio_poe.model.data;

public class Autoproposto extends Proposta{
    private long n_alunoPro;

    public Autoproposto(String ca, String titulo, long n_alunoPro){
        super(ca, titulo);
        this.n_alunoPro = n_alunoPro;
    }

    public String getCa(){
        return super.getCa();
    }
    public void setCa(String ca){
        super.setCa(ca);
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
