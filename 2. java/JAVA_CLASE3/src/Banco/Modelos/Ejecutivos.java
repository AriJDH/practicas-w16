package Banco.Modelos;

import Banco.Interfaces.ConsultaSaldo;
import Banco.Interfaces.Deposito;
import Banco.Interfaces.RetiroEfectivo;
import Banco.Interfaces.Transferencia;

public class Ejecutivos implements Transferencia, Deposito {

    @Override
    public void hacerDeposito () {
        System.out.println("Usuario ejecutivo consultando saldo");

    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Usuario ejecutivo haciendo retiro de efectivo");

    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion fallida.");
    }

}
