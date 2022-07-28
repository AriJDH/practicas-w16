package transacciones.interfaces;

public interface PagoServicios extends Transaccion {
    default void pagarServicio(String servicio) {
        System.out.println("Pagando el servicio " + servicio);
    }
}
