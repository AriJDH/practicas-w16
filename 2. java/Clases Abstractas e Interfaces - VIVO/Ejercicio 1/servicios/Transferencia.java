package interfaces.servicios;

import interfaces.interfaz.Transaccion;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no realizada!");

    }
}
