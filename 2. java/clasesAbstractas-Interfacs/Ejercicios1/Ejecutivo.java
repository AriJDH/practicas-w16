package Ejercicios1;

public class Ejecutivo implements Deposito, Trasferencia{

    @Override
    public void depositar(double monto) {
        System.out.println("Depositar: " + monto);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO OK");
    }

    @Override
    public void trasferencia(double monto) {
        System.out.println("Trasferencia: " + monto);
    }
}
