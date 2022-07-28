package imprimibles.main;

import imprimibles.clases.Curriculum;
import imprimibles.clases.Informe;
import imprimibles.clases.LibroPdf;
import imprimibles.clases.Persona;
import imprimibles.interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Imprimible imp = new Curriculum(new Persona("Sergio"), List.of("Java", "JavaScript", "Python"));
        imp.imprimir();

        imp = new LibroPdf(200, "Eduardo", "Mi libro", "Ficción");
        imp.imprimir();

        imp = new Informe("este es un informe", 3, "yo", "yo también");
        imp.imprimir();
    }
}
