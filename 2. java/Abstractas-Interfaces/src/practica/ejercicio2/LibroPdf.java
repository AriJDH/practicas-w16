package practica.ejercicio2;

public class LibroPdf implements Imprimible{
    private int cantidadDePaginas;
    private String titulo;
    private String autor;
    private String genero;


    public LibroPdf(int catidadDePaginas, String titulo, String autor, String genero) {
        this.cantidadDePaginas = catidadDePaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo el libro "+titulo);
        System.out.println("Autor: "+autor);
        System.out.println("Genero: "+genero);
        System.out.println("Total de paginas: "+ cantidadDePaginas);
    }
}
