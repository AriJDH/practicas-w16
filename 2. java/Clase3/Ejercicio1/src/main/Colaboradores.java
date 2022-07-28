package main;

import interfaces.ConsultarSaldo;
import interfaces.RetiroEfectivo;
import interfaces.Transaccion;

public class Colaboradores implements RetiroEfectivo, ConsultarSaldo, Transaccion {
    @Override
    public void consultarSaldo(String saldo) {
        System.out.println("el saldo para el colaborador es : " + saldo);
    }

    @Override
    public void retiroEfectivo(int monto, boolean t) {
        System.out.println("solicitud de retiro por " +monto);
        if(t){
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
        System.out.println("La transaccion no se realizo correctamente");

    }
}
