package interfaces.servicios;

import interfaces.interfaz.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no realizado!");

    }
}
