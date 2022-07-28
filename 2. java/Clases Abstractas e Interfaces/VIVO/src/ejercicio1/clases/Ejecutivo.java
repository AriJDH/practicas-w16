package ejercicio1.clases;

import ejercicio1.interfaces.Deposito;
import ejercicio1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {


    @Override
    public void realizarDeposito(double importe) {
        System.out.println("Realizando deposito de: $" + importe);
    }

    @Override
    public void transaccionOk(String trx) {
        System.out.println("Transaccion " + trx + " realizada con exito!");
    }

    @Override
    public void transaccionNoOk(String trx) {
        System.out.println("[ERROR] Ocurrío un error en la operación de " + trx + "!");
    }

    @Override
    public void realizarTransferencia(int nroCuenta, double importe) {
        System.out.println("Realizando transferencia a N° " + nroCuenta + " por $" + importe);
    }
}
