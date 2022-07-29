package practicesInterfaceAbstract2;

public class Report extends Print<Report> {
    private String text;
    private int countPages;
    private String author;
    private String reviewer;


    public Report(String text, int countPages, String author, String reviewer) {
        this.text = text;
        this.countPages = countPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    public Report() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Informe: \n" +
                "Texto: " + text +
                "\nCatidad de paginas: " + countPages +
                "\nAutor: " + author +
                "\nRevisor: " + reviewer;
    }
}
