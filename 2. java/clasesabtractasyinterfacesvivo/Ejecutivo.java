package ejercicio1;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void HacerDeposito() {
        System.out.println("Ejecutivo realizo deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Ejecutivo transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ejecutivo transaccion no OK");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Ejecutivo realizo una transferencia");
    }
}
