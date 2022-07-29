package practica.clasesabstractaseinterfaces.ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> atributos = new ArrayList<>() {
            {
                add("Pepe");
                add("Uruguay");
                add("Developer");
            }
        };
        ArrayList<String> habilidades = new ArrayList<>() {
            {
                add("Java");
                add("MySQL");
                add("Git");
            }
        };
        Curriculum curriculum = new Curriculum(atributos, habilidades);
        LibroPDF libroPDF = new LibroPDF(500, "Hernan", "Libro random", "Novela");
        Informe informe = new Informe("Texto de pruebas para informe", 150, "Juan", "Jose");

        ArrayList<Imprimible> imprimibles = new ArrayList<>() {
            {
                add(curriculum);
                add(libroPDF);
                add(informe);
            }
        };

        for (Imprimible imprimible : imprimibles) {
            imprimible.imprimir();
        }
    }
}
