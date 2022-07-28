package ejercicio2;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(
                "Nicolas De Maio",
                LocalDate.of(1999, 12, 7),
                List.of("Java", "Relational DBs", "UML"));

        PdfBook pdfBook = new PdfBook(10, "Victor J.", "Libro Fantastico", "Drama");

        Report report = new Report("Contenido del reporte.", 1, "Martin Jr", "Nicolas DM");

        curriculum.print();
        pdfBook.print();
        report.print();
    }

}
