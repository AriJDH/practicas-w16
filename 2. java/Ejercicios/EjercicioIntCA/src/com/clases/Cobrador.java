package com.clases;

import com.interfaces.ConsultandoSaldo;
import com.interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultandoSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo:\n su saldo es ______");
transaccionOk("Consultar saldo");
    }

    @Override
    public void retirarEfectivo(Double cantidad) {
        System.out.println("Se va a retirar " + cantidad);
    }

    @Override
    public void transaccionOk(String transaccion) {

        System.out.println( transaccion +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("La transacción " + transaccion +  " no se pudo concluir");
    }
}
