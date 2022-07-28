package transacciones.interfaces;

public interface Transferencia extends Transaccion {
    default void transferir(double cantidad, String destino) {
        System.out.println("Transfiriendo " + cantidad + " a " + destino);
    }
}
