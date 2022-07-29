package Ejercicio1;

public class Transferencia implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println(" - Se realizo su transferencia. \n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(" - No se realizo su transferencia. \n");
    }
}
