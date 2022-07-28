package Imprimir;

public class LibroPDF implements IImprimir{
    private int cantidadPagina;
    private String Autor;
    private String Titulo;
    private String Genero;

    public LibroPDF(int cantidadPagina, String autor, String titulo, String genero) {
        this.cantidadPagina = cantidadPagina;
        Autor = autor;
        Titulo = titulo;
        Genero = genero;
    }

    public int getCantidadPagina() {
        return cantidadPagina;
    }

    public void setCantidadPagina(int cantidadPagina) {
        this.cantidadPagina = cantidadPagina;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir Libro PDF");
    }
}
