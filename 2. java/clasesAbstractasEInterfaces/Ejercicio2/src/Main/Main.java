package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Probar distintos tipos de documentos
        Persona fulanito = new Persona("John Doe", 32, "19099344",81.3,1.77);
        List<String> listaSkill = new ArrayList<String>();
        listaSkill.add("Teamworking");
        listaSkill.add("Experiencia como Tech Lead");

        Curriculum cv = new Curriculum(fulanito, listaSkill);
        LibroPDF libro = new LibroPDF("Umberto Eco", "El Nombre de la Rosa","Literatura Universal", 350);
        Informe reporte = new Informe("Este es un reporte hecho en una linea - Todo esta OK.");
        reporte.setAutor("Cosme Fulanito");
        reporte.setRevisor("Editores S.A.");

        System.out.println("---------------");
        System.out.println("Datos CV:");
        cv.mostrarDatos();

        System.out.println("---------------");
        System.out.println("Datos Libro:");
        libro.mostrarDatos();

        System.out.println("---------------");
        System.out.println("Datos Informe:");
        reporte.mostrarDatos();
    }

}
