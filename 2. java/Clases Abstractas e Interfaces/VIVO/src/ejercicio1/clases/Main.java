package ejercicio1.clases;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        System.out.println("Usuario Ejecutivo");
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito(300);
        ejecutivo.transaccionOk("deposito");
        ejecutivo.realizarTransferencia(123, 20);
        ejecutivo.transaccionNoOk("transferencia");

        System.out.println("\n\nUsuario Basic");
        Basic basic = new Basic();
        basic.consultaSaldo(123);
        basic.transaccionOk("consulta de saldo");
        basic.pagarServicio("Factura Luz", 100);
        basic.transaccionOk("pagar servicio");
        basic.retiroEfectivo(1.5);
        basic.transaccionNoOk("retiro efectivo");
    }

}
