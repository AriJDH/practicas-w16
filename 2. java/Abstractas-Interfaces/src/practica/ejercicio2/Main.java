package practica.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Imprimible> documentos = new ArrayList<>();

        Curriculum cv = new Curriculum(new Persona("javier","Gomez",25));
        cv.agregarHabilidad("Programar");
        cv.agregarHabilidad("Ingles");

        documentos.add(cv);

        documentos.add(new LibroPdf(120,"titulo raro","Pedro","Terror"));
        documentos.add(new Informe("Este es el texto",1,"Javi","Bootcamp"));

        documentos.forEach(doc -> doc.imprimir());
        System.out.println("---- Prueba de estatico-----");
        Imprimible.imprimirEstatico(cv);

    }
}
