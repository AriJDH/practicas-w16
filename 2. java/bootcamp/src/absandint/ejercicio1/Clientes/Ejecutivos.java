package absandint.ejercicio1.Clientes;

import absandint.ejercicio1.Transacciones.Deposito;
import absandint.ejercicio1.Transacciones.Transferencia;

public class Ejecutivos implements Deposito, Transferencia{


    @Override
    public void realizarDeposito() {
        System.out.println("Realizando depósito");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción Realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no se pudo realizar");
    }


}
