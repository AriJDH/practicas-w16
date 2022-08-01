package com.documentos;

import com.interfaz.Imprimible;

public class PDF extends Libro implements Imprimible {
    private String  titulo, genero;


    public PDF(int cantidadPaginas, String nombreAutor, String apellidoAutor, String titulo, String genero) {
        super(cantidadPaginas, nombreAutor, apellidoAutor);
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Se imprimio el PDF \n" + this.toString());
    }

    @Override
    public String toString() {
        return "PDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", apellidoAutor='" + apellidoAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
