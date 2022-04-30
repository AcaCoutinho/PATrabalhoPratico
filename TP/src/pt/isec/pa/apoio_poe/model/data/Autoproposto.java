package pt.isec.pa.apoio_poe.model.data;

public class Autoproposto extends Proposta{

    public Autoproposto(String ca, String titulo, long n_alunoAt){
        super(ca, titulo, n_alunoAt);
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
        sb.append("\nCódigo de identificação: " + getCa() + "\tTitulo: " + getTitulo() + "\nNúmero de aluno: " + getN_alunoAt());
        return sb.toString();
    }
}
