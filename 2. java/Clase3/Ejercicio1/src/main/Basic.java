package main;

import interfaces.ConsultarSaldo;
import interfaces.PagoDeServicios;
import interfaces.RetiroEfectivo;
import interfaces.Transaccion;

public class Basic implements ConsultarSaldo, PagoDeServicios, RetiroEfectivo, Transaccion {
    @Override
    public void consultarSaldo(String nombre ) {
        System.out.println("Realizando consulta de saldo para el cliente " + nombre);
    }

    @Override
    public void pagoDeServicios(int pago,boolean t) {
        System.out.println("se realiza un pago de :" +pago);
        if (t){
            tranaccionOK();

        }else {
            transaccionNoOK();
        }
    }

    @Override
    public void retiroEfectivo(int retiro,boolean t) {
        System.out.println("solicitud por el retiro de :" + retiro);
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
        System.out.println("La transaccion no se realizo correctamente");

    }
}
