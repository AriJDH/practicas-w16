package transacciones.interfaces;

public interface Transaccion {
    default void transaccionOk() {
        System.out.println("Transacción completada correctamente");
    }

    default void transaccionNoOk() {
        System.out.println("Hubo un problema al realizar la transacción");
    }
}
