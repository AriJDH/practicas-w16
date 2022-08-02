package poo.ejercicioImprimir;

public class LibroPdf implements Imprimible {

    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
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
    public String toString() {
        return "Libro Pdf:" + "\n" +
                " Cantidad de paginas: " + cantidadDePaginas + "\n" +
                " Autor: " + autor + "\n" +
                " Titulo: " + titulo + "\n" +
                " Genero: " + genero;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
