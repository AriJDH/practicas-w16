package com.tomas.banco;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

public class Main {

    public static void main(String[] args) {

        //Cliente Basic
        Basic objBasic = new Basic();
        objBasic.consultar();
        objBasic.transaccionOk();
        objBasic.pagar();
        objBasic.transaccionOk();
        objBasic.retirar();
        objBasic.transaccionNoOk();


        System.out.println();

        //Cliente Cobrador
        Cobrador objCobrador = new Cobrador();
        objCobrador.retirar();
        objCobrador.transaccionNoOk();
        objCobrador.consultar();
        objCobrador.transaccionOk();

        System.out.println();

        //Cliente Ejecutivo
        Ejecutivo objEjecutivo = new Ejecutivo();
        objEjecutivo.depositar();
        objEjecutivo.transaccionOk();
        objEjecutivo.transferir();
        objEjecutivo.transaccionOk();


    }
}
