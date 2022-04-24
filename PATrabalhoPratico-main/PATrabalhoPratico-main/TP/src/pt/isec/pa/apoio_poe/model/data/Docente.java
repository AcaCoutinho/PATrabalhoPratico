package pt.isec.pa.apoio_poe.model.data;

abstract class Docente {
    private String email;
    private String nome;

    Docente(String email, String nome){
        this.email = email;
        this.nome = nome;
    }

    String getEmail(){
        return email;
    }
    void setEmail(String email){
        this.email = email;
    }

    String getNome(){
        return nome;
    }
    void setNome(String nome){
        this.nome = nome;
    }
}
