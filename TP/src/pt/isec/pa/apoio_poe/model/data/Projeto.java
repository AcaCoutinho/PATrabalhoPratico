package pt.isec.pa.apoio_poe.model.data;

public class Projeto extends Proposta{
    private String rd;
    private Docente proponente;

    public Projeto(String ca, String rd, String titulo, Docente proponente){
        super(ca, titulo, 0);
        this.rd = rd;
        this.proponente = proponente;
    }

    public Projeto(String ca, String rd, String titulo, Docente proponente, long n_alunoAt){
        super(ca, titulo, n_alunoAt);
        this.rd = rd;
        this.proponente = proponente;
    }

    public String getRd(){
        return rd;
    }
    public void setRd(String rd){
        this.rd = rd;
    }

    public Docente getProponente(){
        return proponente;
    }
    public void setProponente(Docente proponente){
        this.proponente = proponente;
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
        sb.append("\nCódigo de identificação: " + getCa() + "\tTitulo: " + getTitulo() + "\nRamo de destino: " + rd);
        sb.append(proponente.toString());
        if(getN_alunoAt() != 0){
            sb.append("\tNúmero de aluno atribuido: " + getN_alunoAt());
        }
        return sb.toString();
    }
}
