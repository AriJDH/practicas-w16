package Ejercicio2;

public class LibroPdf implements Imprimible{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("El libro" + titulo + " contiene " + cantidadPaginas + " paginas, fue escrito por " + autor + " y entra en el genero de " + genero);
    }
}
