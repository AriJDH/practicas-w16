package Ejercicio2.Clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> habilidades = new ArrayList<>();
        habilidades.add("habilidad1");
        habilidades.add("habilidad2");
        habilidades.add("habilidad3");

        Curriculum curriculum = new Curriculum("Pamela","Pereyra",
                "pereyrapame@gmail.com", 25, habilidades);

        curriculum.imprimible();

        System.out.println("PDF");
        LibroEnPDF libroEnPdf = new LibroEnPDF();
        libroEnPdf.setAuthorName("MercadoLibre");
        libroEnPdf.setTitle("En beta continuo");
        libroEnPdf.setGender("Informativo");
        libroEnPdf.setNumberOfPages(50);

        libroEnPdf.imprimible();

        System.out.println("Informe");

        Informe informe = new Informe(1000, 200, "Albert Einsten", "Stephen Hawkings");

        informe.imprimible();
    }
}
