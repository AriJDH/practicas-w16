package Ejercicios2;

public class Libros implements imprimible {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private String genero;

    public Libros(String titulo, String autor, int numeroPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Numero de paginas: " + numeroPaginas);
        System.out.println("Genero: " + genero);
    }
}
