package clases_abs_int.banco;

import clases_abs_int.banco.models.Basic;
import clases_abs_int.banco.models.Cobrador;
import clases_abs_int.banco.models.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basic.consultarSaldo();
        basic.pagarServicio();
        basic.pagarServicio();

        cobrador.retirarEfectivo();
        cobrador.consultarSaldo();

        ejecutivo.depositar();
        ejecutivo.transferir();

    }
}
