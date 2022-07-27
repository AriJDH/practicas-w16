package clases;

public class Libro {

    String titulo;
    String autor;
    int ejemplares;

    public Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadDeEjemplares(){
        return ejemplares;
    }

    public String mostrarLibro(){
        return "Título: " + titulo + " Autor: " + autor + " Ejemplares: " + ejemplares;
    }
}
