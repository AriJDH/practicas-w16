package Ejercicio1.Clases;

import Ejercicio1.Clases.Interfaces.ConsultaSaldo;
import Ejercicio1.Clases.Interfaces.Retiro;

public class Cobradores implements Retiro, ConsultaSaldo {

    private double montoEnCajero = 10000;

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


    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " no pudo ser procesada correctamente");
    }
}
