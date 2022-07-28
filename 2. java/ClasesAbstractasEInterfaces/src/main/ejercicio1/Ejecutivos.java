package main.ejercicio1;

public class Ejecutivos extends Clientes{
    private Deposito unDeposito;
    private Transferencia unTransferencia;

    void realizarDeposito(){
        unDeposito.transaccionOk();
    }
    void realizarTransferencia(){
        unTransferencia.transaccionOk();
    }


}
