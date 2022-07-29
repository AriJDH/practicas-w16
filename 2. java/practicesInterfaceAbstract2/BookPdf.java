package practicesInterfaceAbstract2;

public class BookPdf extends Print<BookPdf> {

    private int countPages;
    private String author;
    private String title;
    private String genre;

    public BookPdf(int countPages, String author, String title, String genre) {
        this.countPages = countPages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public BookPdf() {
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "LibroPdf: \n" +
                "Cantidad de paginas: " + countPages +
                "\nAutor: " + author +
                "\nTitulo: " + title +
                "\nGenero: " + genre ;
    }
}
