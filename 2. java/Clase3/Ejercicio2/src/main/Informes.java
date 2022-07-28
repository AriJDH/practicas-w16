package main;

import interfaces.Imprimible;

public class Informes implements Imprimible {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisr;

    public Informes(String texto, int cantidadPaginas, String autor, String revisr) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisr = revisr;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisr() {
        return revisr;
    }

    public void setRevisr(String revisr) {
        this.revisr = revisr;
    }

    @Override
    public String imprimible() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas='" + cantidadPaginas + '\'' +
                ", autor='" + autor + '\'' +
                ", revisr='" + revisr + '\'' +
                '}';
    }
}
