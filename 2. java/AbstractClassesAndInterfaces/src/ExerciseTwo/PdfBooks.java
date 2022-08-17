package ExerciseTwo;

public class PdfBooks extends Document implements Printable {

    private int pages;
    private String nameAuthor;
    private String title;
    private String gender;

    public PdfBooks() {
    }

    public PdfBooks(int pages, String nameAuthor, String title, String gender) {
        this.pages = pages;
        this.nameAuthor = nameAuthor;
        this.title = title;
        this.gender = gender;
    }

    @Override
    public void toPrint() {
        System.out.println("PdfBooks{" +
                "pages=" + pages +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                '}');
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
