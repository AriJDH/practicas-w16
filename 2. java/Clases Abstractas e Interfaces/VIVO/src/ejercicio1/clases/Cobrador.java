package ejercicio1.clases;

import ejercicio1.interfaces.Retiro;
import ejercicio1.interfaces.Saldo;

public class Cobrador implements Saldo, Retiro {
    @Override
    public double consultaSaldo(int nroCuenta) {
        double saldo = 125.32;
        System.out.println("Saldo disponible N° " + nroCuenta + ": $" + saldo);
        return saldo;
    }

    @Override
    public double retiroEfectivo(double importe) {
        double retiro = 105;
        System.out.println("Retiro de efectivo: $" + retiro);
        return retiro;
    }

    @Override
    public void transaccionOk(String trx) {
        System.out.println("Transaccion "+ trx +" finalizada con exito!");
    }

    @Override
    public void transaccionNoOk(String trx) {
        System.out.println("[ERROR] Ocurrío un error en la operación de "+trx);
    }
}
