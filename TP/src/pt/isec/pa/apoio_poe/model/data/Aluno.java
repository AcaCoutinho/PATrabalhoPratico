package pt.isec.pa.apoio_poe.model.data;

public class Aluno {
    private static long count = 2022000000;
    private long n_aluno;
    private String nome;
    private String email;
    private String siglaC;
    private String siglaR;
    private double grade;
    private boolean access;

    public Aluno(String nome, String siglaC, String siglaR, double grade){
        this.nome = nome;
        this.siglaC = siglaC;
        this.siglaR = siglaR;
        this.grade = grade;
        access = false;
        n_aluno = count;
        createEmail();
        count++;
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

    public boolean turnOnAccess(){
        if(!access){
            access = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean turnOfAccess(){
        if(access){
            access = false;
            return true;
        }else{
            return false;
        }
    }

    public void createEmail(){
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append(n_aluno);
        sb.append("@isec.pt");
        email = sb.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: "+getNome()+"\tNº Aluno: "+ getN_aluno()+"\nEmail: "+getEmail()+"\tCurso: "+getSiglaC()+
                " Ramo: "+getSiglaR()+"\nClassificação: "+getGrade());
        return sb.toString();
    }
}
