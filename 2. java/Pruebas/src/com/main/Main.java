package com.main;

import com.prueba.PruebaStreams;
import com.prueba.PruebaTry;

public class Main {
    public static void main(String[] args) throws Exception {
        PruebaTry objPruebaTry = new PruebaTry();
        PruebaStreams objPruebaStreams = new PruebaStreams();
        //objPruebaTry.falla();
        //objPruebaTry.divisionCero();
        //objPruebaTry.fallaThrow();
        //System.out.println(objPruebaTry.division_real(0,3));

        //  objPruebaStreams.printStram();
        //objPruebaStreams.otroStream();
        //objPruebaStreams.tercerEjemploStream();
        //objPruebaStreams.cuartoEjemploStream();
        System.out.println(objPruebaStreams.quintoEjemploStream());

    }


}
