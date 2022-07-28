package transacciones.interfaces;

public interface Deposito extends Transaccion {
    default void depositar(double cantidad) {
        System.out.println("Depositando " + cantidad);
    }
}
