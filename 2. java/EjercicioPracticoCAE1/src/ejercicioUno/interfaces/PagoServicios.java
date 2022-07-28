package ejercicioUno.interfaces;

public interface PagoServicios extends Transaccion {
    void pagoServicios(String cuenta, double monto);
}
