package Ejercicios2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List skils = List.of("Java", "Python", "C++");
        Curriculums curriculum = new Curriculums("Juan", "Calle falsa 123", "123456789", "prueba@meli.com", 23, skils);
        Libros libro = new Libros("Java", "Juan", 123, "Programacion");
        Informes informe = new Informes(123, 123, "Juan", "Juan");

        System.out.println("Curriculum: ");
        curriculum.imprimir();
        System.out.println();

        System.out.println("Libro: ");
        libro.imprimir();
        System.out.println();

        System.out.println("Informe: ");
        informe.imprimir();
        System.out.println();
    }
}
