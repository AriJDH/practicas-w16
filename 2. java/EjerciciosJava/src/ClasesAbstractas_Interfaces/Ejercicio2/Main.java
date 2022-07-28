package ClasesAbstractas_Interfaces.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> listaHab = new ArrayList<>();
        listaHab.add("Trabajo en equipo");
        listaHab.add("Creatividad");
        listaHab.add("Autodidacta");
        Curriculum cv = new Curriculum("Lucas", "Abbiatici", 23, "lucas.abbiatici@mercadolibre.com", "1160102304", listaHab);
        cv.imprimir(cv);

        System.out.println("----------------------------");

        LibroPdf libro = new LibroPdf(300, "J. K. Rowling", "Harry Potter", "Ciencia Ficción");
        libro.imprimir(libro);

        System.out.println("----------------------------");

        Informe informe = new Informe("textooo", 50, "Pepito", "Pepita");
        informe.imprimir(informe);
    }
}
