package ejercicio2;

import ejercicio2.Documentos.Curriculum;
import ejercicio2.Documentos.Informe;
import ejercicio2.Documentos.LibroPDF;

public class Main {
    public static void main(String[] args) {

        //Datos CV de un postulante
        String[] habilidades = {"proactivo", "tolerancia al trabajo bajo presión", "buenas habilidades blandas", "manejo de excel nivel intermedio"};
        Persona postulante = new Persona("1234567-8", "Michael Fernández", 40);
        Curriculum curriculumVitae = new Curriculum(postulante, habilidades);

        //Datos de un libro en PDF
        Persona autorLibro = new Persona("2345679-0", "Marcela Paz", 42);
        LibroPDF libro = new LibroPDF(autorLibro, 200, "Papelucho y el Marciano", "Infantil, aventura");

        //Datos de un informe
        Persona autorInforme = new Persona("8487456-6", "Claudio Antolín", 39);
        Persona revisorInforme = new Persona("9887654-2", "Toribio Odinson", 60);
        Informe informe = new Informe(autorInforme, 120, revisorInforme, 50);

        //Impresión de data de los objetos
        System.out.println(curriculumVitae.imprimirDocumento());
        System.out.println("");
        System.out.println(libro.imprimirDocumento());
        System.out.println("");
        System.out.println(informe.imprimirDocumento());
    }
}
