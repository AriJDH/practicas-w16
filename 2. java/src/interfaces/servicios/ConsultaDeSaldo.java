package interfaces.servicios;

import interfaces.interfaz.Transaccion;

public class ConsultaDeSaldo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Su saldo es:"+ 1000);
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No tiene saldo!");

    }
}
