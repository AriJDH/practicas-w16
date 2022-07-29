package com.tomas.documentos;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

public class LibroPdf implements Impresion{

    private int cantidadPagina;
    private String nombreAutor;
    private String titulo;
    private String genero;


    //Constructor que recibe los atributos para la clase LibroPdf
    public LibroPdf(int cantidadPagina, String nombreAutor, String titulo, String genero) {
        this.cantidadPagina = cantidadPagina;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    //Métodos getters y setters

    public int getCantidadPagina() {
        return cantidadPagina;
    }

    public void setCantidadPagina(int cantidadPagina) {
        this.cantidadPagina = cantidadPagina;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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

    //Método sobreescrito de la interfaz Impresion para imprimir los datos del Libro en pdf
    @Override
    public void imprimir() {

        System.out.println("------------Libro en PDF------------");
        System.out.println("Cantidad de páginas: " + cantidadPagina);
        System.out.println("Nombre del autor: " + nombreAutor);
        System.out.println("Título del libro: " + titulo);
        System.out.println("Género del libro: " + genero);

    }
}
