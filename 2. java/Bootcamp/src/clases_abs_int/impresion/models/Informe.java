package clases_abs_int.impresion.models;

import clases_abs_int.impresion.interfaces.IImprimir;

public class Informe implements IImprimir {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("IMPRIMIENDO INFORME:");
        System.out.printf("Autor: %s.\nRevisor: %s.\nCantidad de páginas: %s.\nExtracto: %s.\n",
                this.autor, this.revisor, this.cantidadPaginas, this.texto);
        System.out.println();
    }
}
