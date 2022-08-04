package abstractasInterfases.interfaces2;

public class Libros implements Imprimible{

    private int cantDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public Libros(int cantDePaginas, String autor, String titulo, String genero) {
        this.cantDePaginas = cantDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "cantDePaginas=" + cantDePaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
