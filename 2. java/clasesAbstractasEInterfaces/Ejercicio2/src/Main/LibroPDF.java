package Main;

public class LibroPDF extends Documento {

    private String autor;
    private String titulo;
    private String genero;

    // Constructores
    public LibroPDF() {
    }

    public LibroPDF(String autor, String titulo, String genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.setNumDePags(1);
    }

    public LibroPDF(String autor, String titulo, String genero, int paginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.setNumDePags(paginas);
    }

    // Setters y Getters
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    @Override
    public void mostrarDatos() {
        Imprimible.imprimir();
        System.out.println("Información:");
        System.out.println("Título: " + this.titulo + '\n' +
                "Autor: " + this.autor + '\n' +
                "Num. Páginas: " + this.getNumDePags() + '\n' +
                "Género: " + this.genero);
    }

}
