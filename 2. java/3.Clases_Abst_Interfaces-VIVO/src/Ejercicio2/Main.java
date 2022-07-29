package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona unaPersona = new Persona("Karla", "Duran", "1234");
        List<String> skills = new ArrayList<>();
        skills.add("read");
        skills.add("write");

        Curriculum cv = new Curriculum(unaPersona, skills);
        Informe informe = new Informe("Texto del primer informe de trabajo.", 3, "Lola Castillo", "Pablo Martinez");
        LibroEnPDF libroPDF = new LibroEnPDF(10, "Carlos Gomez", "Los lirios", "Drama y Ficcion");

        IImprimible.imprimirDocumento(cv);
        IImprimible.imprimirDocumento(informe);
        IImprimible.imprimirDocumento(libroPDF);


    }
}
