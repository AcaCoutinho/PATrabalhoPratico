package pt.isec.pa.apoio_poe.model.data;

public class Estagio extends Proposta{
    private String ad;
    private String entityId;
    private long n_alunoAt;

    public Estagio(String ca, String titulo, String ad, String entityId){
        super(ca, titulo);
        this.ad = ad;
        this.entityId = entityId;
    }

    public String getAd(){
        return ad;
    }
    public void setAd(String ad){
        this.ad = ad;
    }

    public String getEntityId(){
        return entityId;
    }
    public void setEntityId(String entityId){
        this.entityId = entityId;
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
