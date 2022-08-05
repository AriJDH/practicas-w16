package com.clases;

import com.interfaces.ConsultandoSaldo;
import com.interfaces.PagoServicio;
import com.interfaces.RetiroEfectivo;

public class Basic implements ConsultandoSaldo, PagoServicio, RetiroEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo:\n su saldo es ______");
 }

    @Override
    public void pagarServicio(String tipo) {
        System.out.println("Pagando servicio: " + tipo);
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirando: " + monto);
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println( tipo +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("La transacción " + tipo +  " no se pudo concluir");
    }
}
