package com.banco;

import com.interfases.Transaccion;
import com.interfases.Saldos;

public class Basic extends Montos implements Transaccion, Saldos {
    
    public Basic(double saldos) {
        super(saldos);
    }

    public void PagoServicio(){
        System.out.println("El pago del servicio se hace por: " + saldos);
        if(Math.random() * 2 == 1 ) {
            transaccionOK();
        }else{
            transaccion();
        }
    }

    @Override
    public void ConsultaSaldos() {
        System.out.println("La consulta de saldos para el Basic es:" + saldos);

    }

    @Override
    public void RetiroEfectivo() {
        System.out.println("El Basic retiro el monto de:" + saldos);
    }

    @Override
    public void transaccion() {
        System.out.println("La transaccion del Basic fue fallida");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Se ha realizado la transaccion fue exitosa");
    }
}

