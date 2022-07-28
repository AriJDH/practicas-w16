package ExerciseTwo.actors;

public class LibroPDF extends Documento{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        super("LibroPDF");
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    /*
     * GETTERS 
     */

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    /*
     * SETTERS 
     */

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
    
}
