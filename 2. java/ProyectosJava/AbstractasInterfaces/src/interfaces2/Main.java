package abstractasInterfases.interfaces2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Imprimible libro1 = new Libros(100, "Ernesto", "Lo que se llevo", "Drama");
        Imprimible informe1 = new Informes(3055,50,"pepe", "papa");
        Imprimible curriculum1 = new Curriculums("Jose Alberto", "45654468", "josea@gmail.com", new ArrayList());

        Imprimible.imprimirArchivo(libro1);
        Imprimible.imprimirArchivo(informe1);
        Imprimible.imprimirArchivo(curriculum1);

    }
}
