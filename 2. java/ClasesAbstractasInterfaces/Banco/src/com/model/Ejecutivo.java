package com.model;

import com.interfaz.IDeposito;
import com.interfaz.ITransferencia;

public class Ejecutivo extends Cliente implements IDeposito, ITransferencia {

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no realizada");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Se ha realizado la transferencia");
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Se ha depositado $1'200.000");
    }
}
