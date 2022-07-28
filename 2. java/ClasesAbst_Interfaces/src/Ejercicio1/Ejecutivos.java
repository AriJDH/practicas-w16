package Ejercicio1;

public class Ejecutivos implements Deposito, Transferencia{
    @Override
    public void realizarDeposito(double cantidad) {
        System.out.println("Ha depositado " +(cantidad+1000));
        this.transaccionOk("deposito");
    }

    @Override
    public void realizarTransferencia(String tipoDeTransferencia) {
        System.out.println("Ha realizado " + tipoDeTransferencia + " correctamente.");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("Su transaccion " + tipoTransaccion + " ha sido realizada de manera exitosa.");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("Transaccion: " + tipoTransaccion + " no se ha podido realizar.");
    }


}
