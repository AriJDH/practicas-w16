package ejercicio2;

public class PdfBook implements Printable {

    private int amountOfPages;
    private String author;
    private String title;
    private String genre;

    public PdfBook(int amountOfPages, String author, String title, String genre) {
        this.amountOfPages = amountOfPages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PdfBook{" +
                "amountOfPages=" + amountOfPages +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
