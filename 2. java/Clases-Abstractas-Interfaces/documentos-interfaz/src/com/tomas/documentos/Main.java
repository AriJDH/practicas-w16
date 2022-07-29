package com.tomas.documentos;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Cargue del ArrayList con las habilidades
        ArrayList habilidad = new ArrayList<>();
        habilidad.add("Líder");
        habilidad.add("Maquetado");
        habilidad.add("Edificaciones antisismos");
        habilidad.add("Responsable");

        //Para el curriculum
        Impresion objCurriculo = new Curriculum(8954, "Gerardo", "Bonilla",
                "Arquitecto", 34, "Construcciones SAS", habilidad);

        Impresion.imprimir(objCurriculo);

        System.out.println();

        //Para el libro en pdf
        Impresion objLibro = new LibroPdf(345, "John Katzenbach",
                "El psicoanalista", "Thriller psicológico");

        Impresion.imprimir(objLibro);

        System.out.println();

        //Para el informe
        Impresion objInforme = new Informe("Este es el texto del informe...", 1,
                "Omar Suarez", "Hernán Gonzalez");

        Impresion.imprimir(objInforme);

    }
}
