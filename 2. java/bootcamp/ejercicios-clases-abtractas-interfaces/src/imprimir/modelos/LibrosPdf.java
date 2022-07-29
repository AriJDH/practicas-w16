package imprimir.modelos;

import imprimir.interfaces.Documento;

public class LibrosPdf implements Documento {

    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;


    public LibrosPdf(){}

    public LibrosPdf(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro PDF" + "\n-Titulo: " +titulo+ "\n-Nombre Autor: " +nombreAutor+ "\n-Cantidad paginas: " + cantidadPaginas+ "\n-Genero: "+ genero;
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
}
