package Ejercicio1.Clases;

import Ejercicio1.Interfaces.Depósito;
import Ejercicio1.Interfaces.Transferencia;

public class Ejecutivos implements Depósito, Transferencia {

    @Override
    public void realizarDeposito() {
        System.out.println("Procesando");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " no pudo ser procesada correctamente");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Procesando");
    }
}
