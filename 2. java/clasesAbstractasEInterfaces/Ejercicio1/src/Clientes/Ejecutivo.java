package Clientes;

import Transacciones.Deposito;
import Transacciones.Transaccion;
import Transacciones.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    @Override
    public void hacerDeposito() {
        System.out.println("Realizando Depósito...");

        if(Math.random() < 0.001)
            Transaccion.transaccionNoOk("Deposito");
        else Transaccion.transaccionOk("Deposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Realizando Transferencia...");
        if(Math.random() < 0.1)
            Transaccion.transaccionNoOk("Transferencia");
        else Transaccion.transaccionOk("Transferencia");
    }
}
