package pt.isec.pa.apoio_poe.model.data;

public class Projeto extends Proposta{
    private String rd;
    private Docente proponente;
    private long n_alunoAt;

    public Projeto(String ca,String titulo, String rd, Docente proponente){
        super(ca, titulo);
        this.rd = rd;
        this.proponente = proponente;
        n_alunoAt = 0;
    }

    public Projeto(String ca, String titulo, String rd, Docente proponente, long n_alunoAt){
        super(ca, titulo);
        this.rd = rd;
        this.proponente = proponente;
        this.n_alunoAt = n_alunoAt;
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

    public long getN_alunoAt(){
        if(n_alunoAt == 0){
            return 0;
        }
        return n_alunoAt;
    }
    public void setN_alunoAt(long n_alunoAt){
        this.n_alunoAt = n_alunoAt;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nCódigo de identificação: " + getCa() + "\tTitulo: " + getTitulo() + "\nRamo de destino: " + rd);
        sb.append(proponente.toString());
        if(n_alunoAt != 0){
            sb.append("\tNúmero de aluno atribuido: " + n_alunoAt);
        }
        return sb.toString();
    }
}
