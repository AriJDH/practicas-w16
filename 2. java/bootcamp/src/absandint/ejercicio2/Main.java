package absandint.ejercicio2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> hab = new ArrayList<String>();
        hab.add("Patinar");
        hab.add("Correr");

        System.out.println("Curriculum:");
        Documento cv = new Curriculum("Sofia", "Petrides", "12345678", 27,hab);
        Documento.toString(cv);

        System.out.println("Libro PDF:");
        Documento pdf = new LibrosPDF(10, "Juan Perez", "Libro 1", "Documental");
        Documento.toString(pdf);

        System.out.println("\nInforme:");
        Documento informe = new Informe("Informe final para MELI", 1, "juan perez", "sofia petrides");
        Documento.toString(informe);

    }
}
