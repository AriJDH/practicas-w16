package cliente;

import transacciones.Deposito;
import transacciones.Transferencia;

public class Basic implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizando un depósito");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando una transferencia");

    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion OK");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transaccion NO OK");

    }
}
