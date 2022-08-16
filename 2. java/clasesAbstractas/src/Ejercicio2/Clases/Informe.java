package Ejercicio2.Clases;

import Ejercicio2.Interfaz.Imprimible;

public class Informe  implements Imprimible {

    private int longOfText;
    private int numberOfPages;
    private String authorName;
    private String revisorName;

    public Informe(int longOfText, int numberOfPages, String authorName, String revisorName) {
        this.longOfText = longOfText;
        this.numberOfPages = numberOfPages;
        this.authorName = authorName;
        this.revisorName = revisorName;
    }

    public Informe() {}

    public int getLongOfText() {
        return longOfText;
    }

    public void setLongOfText(int longOfText) {
        this.longOfText = longOfText;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getRevisorName() {
        return revisorName;
    }

    public void setRevisorName(String revisorName) {
        this.revisorName = revisorName;
    }

    @Override
    public void imprimible() {
        System.out.println("El informe tiene una longitud de "+ longOfText +
                " páginas. El numero de paginas es: " + numberOfPages +
                ", El nombre del autor: " + authorName +
                ", Lo revisó: " + revisorName);
    }
}
