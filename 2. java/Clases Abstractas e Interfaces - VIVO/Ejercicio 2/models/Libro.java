package Interfaces2.models;

import Interfaces2.interfaces.Documento;

public class Libro implements Documento {

    private String nombre;
    private int cantidadPaginas;
    private String nombreAutor;
    private String genero;

    public Libro(String nombre, int cantidadPaginas, String nombreAutor, String genero) {
        this.nombre = nombre;
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.genero = genero;
    }

    public Libro() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimirDocumento(String doc) {
        System.out.println(doc);
    }
}
