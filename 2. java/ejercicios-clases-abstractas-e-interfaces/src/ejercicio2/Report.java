package ejercicio2;

public class Report implements Printable {

    private String content;
    private int amountOfPages;
    private String reviewer;
    private String author;

    public Report(String content, int amountOfPages, String reviewer, String author) {
        this.content = content;
        this.amountOfPages = amountOfPages;
        this.reviewer = reviewer;
        this.author = author;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Report{" +
                "content='" + content + '\'' +
                ", amountOfPages=" + amountOfPages +
                ", reviewer='" + reviewer + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

