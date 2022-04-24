package pt.isec.pa.apoio_poe.model.data;

public class Projeto extends Proposta{
    private String rd;
    private Proponente proponente;
    private long n_alunoAt;

    public Projeto(String ca, String titulo, String rd, Proponente proponente){
        super(ca, titulo);
        this.rd = rd;
        this.proponente = proponente;
    }

    public String getRd(){
        return rd;
    }
    public void setRd(String rd){
        this.rd = rd;
    }

    public String getProponente(){
        return proponente.toString();
    }
    public void setEntityId(Proponente proponente){
        this.proponente = proponente;
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
}
