package BancoEjercicio1;

import java.util.Random;

public class Banco {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Random rd = new Random();

        ejecutivo.realizarDeposito(rd.nextBoolean());
        basic.consultaDeSaldo(rd.nextBoolean());
        basic.retiroDeEfectivo(rd.nextBoolean());
        basic.pagosDeServicio(rd.nextBoolean());
        cobrador.consultaDeSaldo(rd.nextBoolean());
        cobrador.retiroDeEfectivo(rd.nextBoolean());



    }

}
