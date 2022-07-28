package ejercicio1.clases;

import ejercicio1.interfaces.Retiro;
import ejercicio1.interfaces.Saldo;
import ejercicio1.interfaces.Servicio;


public class Basic implements Saldo, Retiro, Servicio {

    @Override
    public void transaccionOk(String trx) {
        System.out.println("Transacción "+ trx+" realizada con Exito!");
    }

    @Override
    public void transaccionNoOk(String trx) {
        System.out.println("[ERROR] Transacción "+ trx +" fallida!");
    }


    @Override
    public double retiroEfectivo(double importe) {
        double retiro = 105;
        System.out.println("Retiro de efectivo: $" + retiro);
        return retiro;
    }

    @Override
    public double consultaSaldo(int nroCuenta) {
        double saldo = 125.32;
        System.out.println("Saldo disponible N° " + nroCuenta + ": $" + saldo);
        return saldo;
    }

    @Override
    public void pagarServicio(String tipoServicio, double importe) {
        System.out.println("Pagando el servicio " + tipoServicio + " por $" + importe);
    }
}
