package pt.isec.pa.apoio_poe.model.data;

public class Docente {
    private String email;
    private String nome;
    private boolean tipo; //0 -> proponente ; 1 -> orientador

    public Docente(String email, String nome){
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
}
