package pt.isec.pa.apoio_poe.model.data;

public class Estagio extends Proposta{
    private String ad;
    private String entityId;
    private long n_alunoAt;

    public Estagio(String titulo, String ad, String entityId){
        super(titulo);
        this.ad = ad;
        this.entityId = entityId;
        n_alunoAt = 0;
    }

    public Estagio(String titulo, String ad, String entityId, long n_alunoAt){
        super(titulo);
        this.ad = ad;
        this.entityId = entityId;
        this.n_alunoAt = n_alunoAt;
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

    public String getTitulo(){
        return super.getTitulo();
    }
    public void setTitulo(String titulo){
        super.setTitulo(titulo);
    }

    public long getN_alunoAt(){
        if(n_alunoAt == 0){
            return 0;
        }
        return n_alunoAt;
    }
    public void setN_alunoAt(long n_alunoAt){
        this.n_alunoAt = n_alunoAt;
    }
}
