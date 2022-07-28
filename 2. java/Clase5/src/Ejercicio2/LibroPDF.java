package Ejercicio2;

public class LibroPDF implements Documento {

    protected String titulo;
    protected int cantPaginas;
    protected String autor;
    protected String genero;

    public LibroPDF(String titulo, int cantPaginas, String autor, String genero) {
        this.titulo = titulo;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.genero = genero;
    }

    public LibroPDF() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "titulo='" + titulo + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public String infoDocumento() {
        return toString();
    }
}
