package pt.isec.pa.apoio_poe.model.data;

public abstract class Proposta {
    private String ca;
    private String titulo;

    Proposta(String titulo){
        this.titulo = titulo;
    }

    String getCa(){
        return ca;
    }

    String getTitulo(){
        return titulo;
    }
    void setTitulo(String titulo){
        this.titulo = titulo;
    }
}
