package pt.isec.pa.apoio_poe.model.data;

public class Docente {
    private String email;
    private String nome;
    private boolean orientador;

    public Docente(String nome, String email){
        this.email = email;
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }
    void setEmail(String email){
        this.email = email;
    }

    public String getNome(){
        return nome;
    }
    void setNome(String nome){
        this.nome = nome;
    }

    public boolean getOrientador(){
        return orientador;
    }
    void setOrientador(boolean orientador){
        this.orientador = orientador;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: " + nome + "\tEmail: " + email);
        return sb.toString();
    }
}
