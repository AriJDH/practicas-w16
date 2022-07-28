package Entity;

import Interface.Deposito;
import Interface.Transferencia;

public class Ejecutivo extends Cliente implements Deposito,Transferencia {


    @Override
    public void deposito() {
        System.out.println("Deposito del ejecutivo");
    }

    @Override
    public void transferencia() {
        System.out.println("Transferencia del ejecutivo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok del ejecutivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion rechazada del ejecutivo");
    }
}
