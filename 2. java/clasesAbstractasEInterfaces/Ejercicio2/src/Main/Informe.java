package Main;

import static java.lang.Math.round;

public class Informe extends Documento{

    private String texto;
    private String autor;
    private String revisor;

    // Constructores

    public Informe() {
    }

    public Informe(String texto) {
        this.texto = texto;
        this.setNumDePags(1+round(texto.length()/500));
    }

    public Informe(String texto, String autor, String revisor) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.setNumDePags(1+round(texto.length()/500));
    }

    // Setters y Getters

    public void setTexto(String texto) {
        this.texto = texto;
        this.setNumDePags(1+round(texto.length()/500));
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }

    @Override
    public void mostrarDatos() {
        Imprimible.imprimir();
        System.out.println("Información:");
        System.out.println("Autor: " + this.autor + '\n' +
                            "Revisor: " + this.autor + '\n' +
                            "Num. de Pags.: " + this.getNumDePags());
        System.out.println("Texto: \n" + this.texto);
    }
    // texto de n long, cant pags, autor, revisor
}
