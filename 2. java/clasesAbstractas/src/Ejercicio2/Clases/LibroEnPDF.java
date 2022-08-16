package Ejercicio2.Clases;

import Ejercicio2.Interfaz.Imprimible;

public class LibroEnPDF implements Imprimible {
    private int numberOfPages;
    private String authorName;
    private String Title;
    private String gender;

    public LibroEnPDF(int numberOfPages, String authorName, String title, String gender) {
        this.numberOfPages = numberOfPages;
        this.authorName = authorName;
        Title = title;
        this.gender = gender;
    }

    public LibroEnPDF() {
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "Title= '" + Title + '\'' +
                        ", AuthorName= " + authorName +
                        ", NumberOfPages= " + numberOfPages +
                        ", Gender= '" + gender + '\'';
    }


    @Override
    public void imprimible() {
        System.out.println(
                "LibroEnPDF " + toString()
        );
    }
}
