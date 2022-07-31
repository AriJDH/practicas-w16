package documentos.clases;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<String>();
        habilidades.add("Python");
        habilidades.add("Java");
        habilidades.add("Docker");
        habilidades.add("Fury");
        Curriculums curriculum = new Curriculums("Martin", "Hernandez", 26, "Soltero", "Desarrollador de software", habilidades);

        Informes informe = new Informes("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 8, "Lucía Rojas", "Ingeniero Robayo");

        LibrosPDF libro = new LibrosPDF(64, "Julian", "Comunicaciones I", "Telecomunicaciones");

        curriculum.imprimir("Curriculum Vitae");
        informe.imprimir("Informe");
        libro.imprimir("Libro en PDF");

    }
}