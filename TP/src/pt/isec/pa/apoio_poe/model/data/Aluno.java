package pt.isec.pa.apoio_poe.model.data;

public class Aluno{
    private long n_aluno;
    private String nome;
    private String email;
    private String siglaC;
    private String siglaR;
    private double grade;
    private boolean access;
    private Proposta propAtribuida;

    public Aluno(long n_aluno, String nome, String email, String siglaC, String siglaR, double grade, boolean access){
        this.nome = nome;
        this.siglaC = siglaC;
        this.siglaR = siglaR;
        this.grade = grade;
        this.access = access;
        this.n_aluno = n_aluno;
        this.email = email;
    }

    public long getN_aluno(){
        return n_aluno;
    }
    public void setN_aluno(long n_aluno){
        this.n_aluno = n_aluno;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSiglaC(){
        return siglaC;
    }
    public void setSiglaC(String siglaC){
        this.siglaC = siglaC;
    }

    public String getSiglaR(){
        return siglaR;
    }
    public void setSiglaR(String siglaR){
        this.siglaR = siglaR;
    }

    public double getGrade(){
        return grade;
    }
    public void setGrade(double grade){
        this.grade = grade;
    }

    public Proposta getPropAtribuida(){ return propAtribuida; }
    public void setPropAtribuida(Proposta propAtribuida){ this.propAtribuida = propAtribuida; }

    public boolean getAccess(){ return access; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: "+getNome()+"\tNº Aluno: "+ getN_aluno()+"\nEmail: "+getEmail()+"\tCurso: "+getSiglaC()+
                " Ramo: "+getSiglaR()+"\nClassificação: "+getGrade());
        if(propAtribuida != null){
            sb.append("\nPROPOSTA-----" + propAtribuida.toString() + "\n----------\n");
        }
        if(access){
            sb.append(" Possui acesso a estágio");
        }else{
            sb.append(" Não possui acesso a estágio");
        }
        return sb.toString();
    }
}
