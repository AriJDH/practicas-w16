package practica.clasesabstractaseinterfaces.ejercicio1.transacciones;

public class Deposito implements Transactable {

    protected double saldo;
    protected double cantidadDeposito;

    public Deposito(double saldo, double cantidadDeposito) {
        this.saldo = saldo;
        this.cantidadDeposito = cantidadDeposito;
    }

    @Override
    public void transaccionOK() {
        System.out.println("Deposito realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. El deposito no puedo ser realizado.");
    }

    public void depositar() {
        System.out.println("Realizando deposito");
    }
}
