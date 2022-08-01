package com.banco;
import com.interfases.Transaccion;
import com.main.Main;

public class Ejecutivo extends Montos implements Transaccion {

    public Ejecutivo(double saldo){
        super(saldo);
    }


    public void Deposito(){
        System.out.println("El ejecutivo acaba de depositar: " + saldos);
        transaccionOK();
    }
    public void Trasferencia(){
        System.out.println("El Ejecutivo realializo una transferencia de: " + saldos);
        if(Math.random() * 2 == 1 ) {
            transaccionOK();
        }else{
            transaccion();
        }
    }

    @Override
    public void transaccion() {
        System.out.println("La transaccion del ejecutivo fallida");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Se ha realizado la transaccion fue exitosa");
    }
}
