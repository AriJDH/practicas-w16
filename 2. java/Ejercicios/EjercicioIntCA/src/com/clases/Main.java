package com.clases;

public class Main {

    public static void main(String[] args) {


        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransferencia();
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.pagarServicio("Cuotas");
        Cobrador cobrador = new Cobrador();
        cobrador.retirarEfectivo(200d);
        cobrador.consultarSaldo();



    }
}
