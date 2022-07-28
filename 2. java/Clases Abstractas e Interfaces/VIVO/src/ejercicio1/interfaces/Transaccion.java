package ejercicio1.interfaces;

public interface Transaccion {
    void transaccionOk(String trx);

    void transaccionNoOk(String trx);
}
