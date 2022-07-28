package transacciones.interfaces;

public interface RetiroEfectivo extends Transaccion {
    default void retirar(double cantidad) {
        System.out.println("Retirando " + cantidad);
    }
}
