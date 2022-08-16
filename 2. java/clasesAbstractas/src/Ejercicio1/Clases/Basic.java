package Ejercicio1.Clases;

import Ejercicio1.Interfaces.ConsultaSaldo;
import Ejercicio1.Interfaces.PagoServicios;
import Ejercicio1.Interfaces.Retiro;

public class Basic implements ConsultaSaldo, PagoServicios, Retiro {

    private double montoEnCajero = 10000;

    @Override
    public void retirarEfectivo(double montoAretirar) {
        System.out.println("Retiro de efectivo en proceso");
        if (montoAretirar <= montoEnCajero) {
            System.out.println("Retiro de efectivo es de :" + montoAretirar);
            montoEnCajero = montoEnCajero - montoAretirar;
            System.out.println("Te queda :" + montoEnCajero);
            transaccionOk("retiroEfec");
        } else {
            transaccionNoOk("retiroEfec");
        }
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Procesando su consulta de saldo");

        if (montoEnCajero == montoEnCajero) {
            System.out.println("Su saldo es de :" + montoEnCajero);
            transaccionOk("consulta de Saldo");
        } else {
            transaccionNoOk("consulta de Saldo");
        }
    }

    public void pagoDeServicios(String servicio, Double montoApagar){
        System.out.println("El servicio a pagar es: "+ servicio);
        if(montoEnCajero < montoApagar){
            transaccionNoOk("pago de servicio " + servicio);
        }else {
            montoEnCajero = montoEnCajero - montoApagar;
            transaccionOk("pago de servicios");
        }
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " no pudo ser procesada correctamente");
    }
}
