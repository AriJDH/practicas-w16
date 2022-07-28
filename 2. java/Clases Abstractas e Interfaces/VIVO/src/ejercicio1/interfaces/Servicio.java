package ejercicio1.interfaces;

public interface Servicio extends Transaccion {

    void pagarServicio(String tipoServicio, double importe);

}
