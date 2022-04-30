package pt.isec.pa.apoio_poe.model.data;

public class Estagio extends Proposta{
    private String ad;
    private String entityId;

    public Estagio(String ca, String ad, String titulo, String entityId){
        super(ca, titulo, 0);
        this.ad = ad;
        this.entityId = entityId;
    }

    public Estagio(String ca, String ad, String titulo, String entityId, long n_alunoAt){
        super(ca, titulo, n_alunoAt);
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

    public String getTitulo(){
        return super.getTitulo();
    }
    public void setTitulo(String titulo){
        super.setTitulo(titulo);
    }

    public long getN_alunoAt(){ return super.getN_alunoAt(); }
    public void setN_alunoAt(long n_alunoAt){
        super.setN_alunoAt(n_alunoAt);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nCódigo de identificação: " + getCa() + "\tTitulo: " + getTitulo() + "\nÁrea de destino: " + ad);
        sb.append("\tEntidade de acolhimento: " + entityId);
        if(getN_alunoAt() != 0){
            sb.append("\tNúmero de aluno atribuido: " + getN_alunoAt());
        }
        return sb.toString();
    }
}
