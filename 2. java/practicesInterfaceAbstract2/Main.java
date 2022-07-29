package practicesInterfaceAbstract2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------------------------");

        BookPdf bookFantastic = new BookPdf(134, "Mariana", "De los dulces", "fantasia");
        bookFantastic.printDocument(bookFantastic);

        System.out.println("----------------------------");

        List<String> skills = new ArrayList<>();
        skills.add("Amable");
        skills.add("Responsable");
        Curriculum curriculum = new Curriculum("Mariana", "Cano", "mari@gmail.com", skills);
        curriculum.printDocument(curriculum);

        System.out.println("----------------------------");

        Report report = new Report("Hola este es un reporte", 34, "Mariana", "Ruth");
        report.printDocument(report);
    }
}
