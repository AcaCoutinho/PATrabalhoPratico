package pt.isec.pa.apoio_poe.model.data;

public class Orientador extends Docente{
    public Orientador(String email, String nome){
        super(email, nome);
    }

    public String getEmail(){
        return super.getEmail();
    }
    public void setEmail(String email){
        super.setEmail(email);
    }

    public String getNome(){
        return super.getNome();
    }
    public void setNome(String nome){
        super.setNome(nome);
    }
}
