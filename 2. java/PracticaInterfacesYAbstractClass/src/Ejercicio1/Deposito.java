package Ejercicio1;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOK() {
        System.out.println("Deposito realizado con exito.");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Error al depositar");
    }

    public double ejecutar(double saldo, double monto) {
        transaccionOK();
        return saldo + monto;
    }
}
