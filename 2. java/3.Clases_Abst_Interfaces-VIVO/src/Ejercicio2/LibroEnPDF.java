package Ejercicio2;

public class LibroEnPDF implements IDocumento {
    private int cantPages;
    private String nameAuthor;
    private String title;
    private String genre;

    public LibroEnPDF(int cantPages, String nameAuthor, String title, String genre) {
        this.cantPages = cantPages;
        this.nameAuthor = nameAuthor;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString(){
        return "----Informacion del Libro PDF:\n " +
                "-- Cantidad de Paginas: " + cantPages + " \n" +
                "-- Autor: " + nameAuthor + " \n" +
                "-- Titulo: " + title + " \n" +
                "-- Genero: " + genre + " \n";
    }
}
