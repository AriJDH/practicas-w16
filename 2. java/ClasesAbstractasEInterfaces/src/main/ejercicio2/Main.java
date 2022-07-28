package main.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Persona unaPersona = new Persona("Doris", "Lessing", "298387464", 75);
        List<String> habilidad = new ArrayList<>();
        habilidad.add("Leer");
        habilidad.add("Correr");
        Curriculums cv = new Curriculums(unaPersona, habilidad);
        Informes informe = new Informes("......", 3,"Laura","Sofia");
        LibrosEnPDF pdf = new LibrosEnPDF(2,"Doris Lessing","Las carceles que elegimos", "ensayo");
        
        cv.imprimirDocumento();
        System.out.println('\n');
        informe.imprimirDocumento();
        System.out.println('\n');
        pdf.imprimirDocumento();
    }
}
