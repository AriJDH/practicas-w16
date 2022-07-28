package Interfaces2.models;

import Interfaces2.interfaces.Documento;

public class Informe implements Documento {

    private String autor;
    private String revisor;
    private int cantidadPagina;
    private String texto;

    public Informe(String autor, String revisor, int cantidadPagina, String texto) {
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPagina = cantidadPagina;
        this.texto = texto;
    }

    public Informe() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public int getCantidadPagina() {
        return cantidadPagina;
    }

    public void setCantidadPagina(int cantidadPagina) {
        this.cantidadPagina = cantidadPagina;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantidadPagina=" + cantidadPagina +
                ", texto='" + texto + '\'' +
                '}';
    }

    @Override
    public void imprimirDocumento(String doc) {
        System.out.println(doc);
    }
}
