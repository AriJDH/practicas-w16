package Ejercicio2.Clases;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        ArrayList<Curriculum> habilidades = new ArrayList<Curriculum>();
        Curriculum curriculum = new Curriculum("Gabriel", "Morales", 25, 66453654);
        Curriculum curriculum1 = new Curriculum("Daniela", "Arenas", 25, 66453331);
        Curriculum curriculum2 = new Curriculum("Felipe", "Morales", 19, 22453331);
        Curriculum curriculum3 = new Curriculum("Claudia", "Valdes", 25, 24534331);

        LibroPDF libroPDF = new LibroPDF(30,"Charles","Prueba","Terror");
        libroPDF.realizarImprecion();

        Informes informes = new Informes(20,20,"Gabo","Daniela");

        habilidades.add(curriculum);
        habilidades.add(curriculum1);
        habilidades.add(curriculum2);
        habilidades.add(curriculum3);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Curriculums disponibles en lista");
        habilidades.forEach((n) -> System.out.println("Nombre: " + n.getNombre() + " Apellido; " + n.getApellido() + " Edad: " + n.getEdad() + " Numero; " + n.getNumero()));
        curriculum.realizarImprecion();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Cantidad de paginas: "+libroPDF.getCantidadPaginas()+" Nombre autor; "+libroPDF.getNombreAutor()+" Titulo:  "+libroPDF.getTitulo()+" Genero: "+libroPDF.getGenero());
        libroPDF.realizarImprecion();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Longitud: "+informes.getLongitud()+" Cantidad paginas: "+informes.getCantidadPaginas()+" Autor: "+informes.getAutor()+" Revision: "+informes.getRevisor());
        informes.realizarImprecion();
        System.out.println("--------------------------------------------------------------------------");




    }


}
