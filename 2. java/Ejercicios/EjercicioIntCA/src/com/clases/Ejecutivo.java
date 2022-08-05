package com.clases;

import com.interfaces.Depositando;
import com.interfaces.Transferencia;

public class Ejecutivo implements Depositando, Transferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Haciendo deposito, aguarde un momento");
        transaccionOk("Deposito");
    }

    @Override
    public void hacerTransferencia() {
        transaccionNoOk("Hacer transferencia");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println(tipo + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("La transacción " + tipo + " no se pudo concluir");
    }
}
