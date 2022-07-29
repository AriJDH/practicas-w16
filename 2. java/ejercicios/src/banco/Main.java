package banco;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        Basic b = new Basic();
        Cobrador c = new Cobrador();
        Ejecutivo e = new Ejecutivo();

        System.out.println("_______Basic____");
        b.consultarSaldo();
        b.pagarServicios();
        b.retirarEfectivo();
        b.transaccionNoOK();
        b.transaccionNoOK();
        System.out.println("_________________");

        System.out.println("_______Ejecutivo___");
        e.depositar();
        e.transferir();
        e.transaccionNoOK();
        e.transaccionNoOK();
        System.out.println("_________________");

        System.out.println("_______Cobrador____");
        c.consultarSaldo();
        c.retirarEfectivo();
        c.transaccionNoOK();
        c.transaccionNoOK();
        System.out.println("_________________");
    }
}
