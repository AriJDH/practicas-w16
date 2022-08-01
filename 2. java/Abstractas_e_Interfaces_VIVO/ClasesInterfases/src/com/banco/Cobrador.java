package com.banco;

import com.interfases.Saldos;
import com.interfases.Transaccion;

public class Cobrador extends Montos implements Transaccion, Saldos {

    private double saldo;

    public Cobrador() {
    }

    public Cobrador(double saldo) {
        super(saldo);
    }

    @Override
    public void ConsultaSaldos() {
        System.out.println("La consulta de saldo para el cobrador es:" + saldos);

    }

    @Override
    public void RetiroEfectivo() {
        System.out.println("El cobrador retiro el monto de:" + saldos);
        if(Math.random() * 2 == 1 ) {
            transaccionOK();
        }else{
            transaccion();
        }
    }

    @Override
    public void transaccion() {
        System.out.println("La transaccion fue fallida");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Se ha realizado la transaccion fue exitosa");
    }
}
