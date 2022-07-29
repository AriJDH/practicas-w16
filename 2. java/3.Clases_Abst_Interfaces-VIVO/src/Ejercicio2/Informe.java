package Ejercicio2;

public class Informe implements IDocumento {
    private String text;
    private int cantPages;
    private String author;
    private String reviewer;

    public Informe(String text, int cantPages, String author, String reviewer) {
        this.text = text;
        this.cantPages = cantPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public String toString(){
        return "----Informacion del Informe:\n " +
                "-- Texto: " + text + " \n" +
                "-- Cantidad de Paginas: " + cantPages + " \n" +
                "-- Autor: " + author + " \n" +
                "-- Revisor: " + reviewer + " \n";
    }
}
