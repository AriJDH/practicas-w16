package ejercicioUno.interfaces;

public interface Transaccion {
    void transaccionOk(String tipoTransaccion);
    void transaccionNoOk(String tipoTransaccion);
}
