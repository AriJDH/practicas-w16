/*
Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes tipos de documentos.
Entre los tipos de documentos se encuentran:

Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.

Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.

Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método estático
de una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso el contenido.


 */


package com.main;

import com.documentos.Curriculum;
import com.documentos.Informes;
import com.documentos.PDF;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec iaculis at justo ut dictum. Nullam ultrices, dolor nec aliquet congue, mauris felis rhoncus justo, mollis blandit lectus sem id arcu.";

        List<String> listaHabilidades = new ArrayList<String>();

        listaHabilidades.add("Comer");
        listaHabilidades.add("Dormir");
        listaHabilidades.add("Tender la cama");

        Curriculum objCurriculum = new Curriculum("pepito", "Perez", 123456, 26, listaHabilidades);
        PDF objPDF = new PDF(23, "Pepito", "Perez", "como dormir y no morir en el intento", "Autoayuda");
        Informes objInforme = new Informes(45, "Juan", "Roa", texto, "Panamericana");


        objCurriculum.imprimir();
        objPDF.imprimir();
        objInforme.imprimir();
    }
}
