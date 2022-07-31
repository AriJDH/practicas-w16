package BancoEjercicio1;

import java.util.Random;

public class Cobrador implements Transaccion,Cajero{


    @Override
    public void transaccionOk() {
            System.out.println("Transaccion del cliente cobrador realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion del cliente cobrador no realizada");
    }

    @Override
    public void retiroDeEfectivo(boolean condicion) {
        if(condicion){
            System.out.println("Realizando retiro de efectivo del cliente cobrador");
            transaccionOk();
        }
        transaccionNoOk();
    }

    @Override
    public void consultaDeSaldo(boolean condicion) {
        if(condicion){
            System.out.println("Realizando consulta de saldo del cliente cobrador");
            transaccionOk();
        }
        transaccionNoOk();
    }
}
