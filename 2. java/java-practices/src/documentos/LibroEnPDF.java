package documentos;

public class LibroEnPDF extends Documento implements Imprimible {
    private int cantidadDePaginas;
    private String nombreDelAutor;
    private String titulo;
    private String genero;

    public LibroEnPDF(){
        this.cantidadDePaginas = 0;
        this.nombreDelAutor = "";
        this.titulo = "";
        this.genero = "";
    }

    public LibroEnPDF(int cantidadDePaginas, String nombreDelAutor, String titulo, String genero){
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadDePaginas() {
        return this.cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreDelAutor() {
        return this.nombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        this.nombreDelAutor = nombreDelAutor;
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

    @Override
    public void imprimirContenido() {
        System.out.println("Libro en PDF impreso.");
    }
}
