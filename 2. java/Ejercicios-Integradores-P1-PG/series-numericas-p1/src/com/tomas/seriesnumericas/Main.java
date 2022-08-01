package com.tomas.seriesnumericas;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 01 de Agosto 2022
 */

public class Main {

    public static void main(String[] args) {

        //Serie de dos
        System.out.println("-------Serie de dos en dos-------------");

        SerieDos objSerieDos = new SerieDos();
        System.out.println(objSerieDos.devolverNumero());
        System.out.println(objSerieDos.devolverNumero());
        System.out.println(objSerieDos.devolverNumero());
        System.out.println(objSerieDos.devolverNumero());

        //Serie de impares
        System.out.println();
        System.out.println("-------Serie de impares-------------");
        SerieUno objSerieUno = new SerieUno();
        System.out.println(objSerieUno.devolverNumero());
        System.out.println(objSerieUno.devolverNumero());
        System.out.println(objSerieUno.devolverNumero());
        System.out.println(objSerieUno.devolverNumero());

        //Serie de tres en tres
        System.out.println();
        System.out.println("-------Serie de tres en tres-------------");
        SerieTres objSerieTres = new SerieTres();
        System.out.println(objSerieTres.devolverNumero());
        System.out.println(objSerieTres.devolverNumero());
        System.out.println(objSerieTres.devolverNumero());
        System.out.println(objSerieTres.devolverNumero());


    }
}
