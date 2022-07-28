package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] habilidades = {"Programacion", "Solucion de puzzles"};
        Curriculum curriculum = new Curriculum("Santiago", 19, habilidades);
        curriculum.imprimir();
        System.out.println();

        LibroPdf libro = new LibroPdf(235, "Gabo", "Año y pico de soledad", "Terror");
        libro.imprimir();
        System.out.println();

        Informe informe = new Informe("En este informe se va a informar lo que se tiene que informar cuando se tiene que informar para que se bien informado", 20, "Yo", "Tambien igual");
        informe.imprimir();
    }
}
