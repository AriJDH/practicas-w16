package Ejercicio1;

public interface Transaccionable {
    void transaccionOk(String tipoTransaccion);
    void transaccionNoOk(String tipoTransaccion);

}
