package com.documentos;
import com.documentos.PDF;
import com.interfaz.Imprimible;

public class Informes extends Libro implements Imprimible {

    private String texto, revisor;

    public Informes(int cantidadPaginas, String nombreAutor, String apellidoAutor, String texto, String revisor) {
        super(cantidadPaginas, nombreAutor, apellidoAutor);
        this.texto = texto;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Se imprimio el Informe \n" + this.toString());
    }

    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                "longitud del texto: " + texto.length() +
                ", revisor='" + revisor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", apellidoAutor='" + apellidoAutor + '\'' +
                '}';
    }
}
