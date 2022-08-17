package ExerciseTwo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();

        List<String> skills = new ArrayList<>();
        skills.add("Responsable");
        skills.add("Proactivo");
        skills.add("Compañerista");
        Curriculum curriculum = new Curriculum(new Person("1073525066", "Anggy", "Arguello", 24, "3218346098"), skills);

        PdfBooks pdfBooks = new PdfBooks(100, "Mario mendoza", "Satanas", "Novela");

        Report report = new Report("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum p150, sages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 150, "Lorem", "Ipsum");

        documents.add(curriculum);
        documents.add(pdfBooks);
        documents.add(report);

        for(Document document : documents){
            document.toPrint();
        }

    }
}
