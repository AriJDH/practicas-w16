package main.ejercicio2;

public class LibrosEnPDF implements Imprimir{

    private int cantidadDePaginas;
    private String nombreDelAutor;
    private String titulo;
    private String genero;

    public LibrosEnPDF(int cantidadDePaginas, String nombreDelAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro en PDF{" +
                "cantidad de paginas = " + cantidadDePaginas +
                ", nombre del autor = " + nombreDelAutor +
                ", titulo = " + titulo +
                ", genero = " + genero +
                "}";
    }
    @Override
    public void imprimirDocumento() {
        System.out.printf(this.toString());

    }
}
