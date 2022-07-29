package Ejercicio1;

public class Deposito implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println(" - Se realizo su deposito. \n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(" - No se realizo su deposito. \n");
    }
}
