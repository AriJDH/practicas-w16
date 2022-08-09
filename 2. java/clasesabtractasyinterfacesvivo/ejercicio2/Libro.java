package ejercicio2;

public class Libro {
    private int cantDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public int getCantDePaginas() {
        return this.cantDePaginas;
    }

    public void setCantDePaginas(int cantDePaginas) {
        this.cantDePaginas = cantDePaginas;
    }

    public String getNombreAutor() {
        return this.nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Libro(int cantDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantDePaginas = cantDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "cantDePaginas=" + cantDePaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
