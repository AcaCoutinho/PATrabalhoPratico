package pt.isec.pa.apoio_poe.model.data;

public class Docente {
    private String email;
    private String nome;
    private boolean orientador;
    private Projeto projeto;

    public Docente(String nome, String email){
        this.email = email;
        this.nome = nome;
        orientador = false;
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
    public void setOrientador(boolean orientador){
        this.orientador = orientador;
    }

    public Proposta getProjeto(){ return projeto; }
    public void setProjeto(Projeto projeto){ this.projeto = projeto; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ").append(nome).append("\tEmail: ").append(email + "\n");
        if(orientador){
            sb.append("Código do projeto associado: ");
            sb.append(projeto.getCa());
            sb.append("\n");
        }
        return sb.toString();
    }
}
