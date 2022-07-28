package Ejercicio2;

public class PDF extends Escrito implements Imprimible{
    private String titulo;
    private String genero;

    public PDF(String autor, int cantidadPaginas, String titulo, String genero) {
        super(autor, cantidadPaginas);
        this.titulo = titulo;
        this.genero = genero;
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
        return "{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadPaginas='" + cantidadPaginas + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo PDF:");
        System.out.println(this.toString());
    }
}

