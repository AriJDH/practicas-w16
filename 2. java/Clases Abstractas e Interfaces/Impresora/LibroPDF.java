package Impresora;

public class LibroPDF implements Imprimible{

    String cantidadDePaginas;
    String autor;
    String titulo;
    String genero;

    public LibroPDF(String cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(String cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
        System.out.println("IMPRIMIENDO LibroPDF");
        System.out.println("Cantidad de paginas: " + getCantidadDePaginas());
        System.out.println("Autor: " + getAutor());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Genero: " + getGenero());
        System.out.println("/////////////////////////////////");
    }
}
