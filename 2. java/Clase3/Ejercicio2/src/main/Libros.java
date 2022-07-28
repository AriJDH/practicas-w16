package main;

import interfaces.Imprimible;

public class Libros implements Imprimible {
    private int cantPaginas;
    private String nombre;
    private String titulo;
    private String genero;

    public Libros(int cantPaginas, String nombre, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombre = nombre;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public String imprimible() {
        return "Libros{" +
                "cantPaginas='" + cantPaginas + '\'' +
                ", nombre=" + nombre +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
