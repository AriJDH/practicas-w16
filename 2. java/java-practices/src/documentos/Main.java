package documentos;

import java.util.ArrayList;
import java.util.List;

/*
 * Ejercicio > Modulo 5: Java > ClasesAbstractasEInterfaces-VIVO
 * ESTADO: Finalizado (falta revisión).
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args){
        Persona persona = new Persona("Gonzalo Nahuel", "Di Pierro", "12.345.678");
        List<String> listaDeHabilidades = new ArrayList();
        listaDeHabilidades.add("C#");
        listaDeHabilidades.add("Java");
        listaDeHabilidades.add("JavaScript");

        Documento curriculum = new Curriculum(persona, listaDeHabilidades);
        Documento libroEnPDF = new LibroEnPDF(350, "J. K. Rowling", "Harry Potter y la Piedra Filosofal", "Fantasía y Aventuras");
        Documento informe = new Informe("Texto", 10, "Gonzalo Nahuel Di Pierro", "Martin Marquez");

        ((Imprimible)curriculum).imprimirContenido();
        ((Imprimible)libroEnPDF).imprimirContenido();
        ((Imprimible)informe).imprimirContenido();
        System.out.println("\n¡IMPRESIONES REALIZADAS CON ÉXITO!");
    }
}
