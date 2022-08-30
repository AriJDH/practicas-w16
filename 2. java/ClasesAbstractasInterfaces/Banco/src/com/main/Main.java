package com.main;

import com.model.Basic;
import com.model.Cobrador;
import com.model.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        System.out.println("\n****** BASIC ******");
        basic.consultarSaldo();
        basic.retirarEfectivo();
        basic.pagarServicios();
        basic.transaccionOk();
        basic.transaccionNoOk();

        System.out.println("\n***** COBRADOR ******");
        cobrador.retirarEfectivo();
        cobrador.consultarSaldo();
        cobrador.transaccionOk();
        cobrador.transaccionNoOk();

        System.out.println("\n***** EJECUTIVO ******");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
        ejecutivo.transaccionOk();
        ejecutivo.transaccionNoOk();

    }
}
