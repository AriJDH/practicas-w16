package main;

import interfaces.Deposito;
import interfaces.Transaccion;
import interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia,Transaccion {
    @Override
    public void deposito(double deposito,boolean t) {
        System.out.println("se realizo un deposito de : " + deposito);
        if (t){
            tranaccionOK();

        }else {
            transaccionNoOK();
        }
    }




    @Override
    public void tranaccionOK() {
        System.out.println("La transaccion se realizo correctamente");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("La transaccion n se realizo correctamente");
    }

    @Override
    public void transferencia(double monto, boolean t) {
        System.out.println("Realizando una trasnferencia por el monto : " + monto);
        if(t){
            tranaccionOK();
        }else {
            transaccionNoOK();
        }
    }
}
