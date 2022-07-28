package practica.ejercicio1;

public class Ejecutivo implements Deposito, Transferencia {

    private double saldo = 100000;

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al realizar la transaccion");

    }


    @Override
    public void realizarDeposito(double cantidad) {
        System.out.println("Ejecutivo realizando transferencia");
        saldo += cantidad;

    }

    @Override
    public void realizarTransferencia(double cantidad) {
        if (cantidad < saldo) {
            saldo -= cantidad;
            transaccionOk();
        } else {
            transaccionNoOk();
        }

    }
}
