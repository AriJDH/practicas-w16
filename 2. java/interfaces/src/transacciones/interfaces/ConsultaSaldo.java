package transacciones.interfaces;

public interface ConsultaSaldo extends Transaccion {
    default void consultarSaldo() {
        System.out.println("Consultado saldo...");
    }
}
