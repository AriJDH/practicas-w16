package Ejercicio1;

public interface Transferencia extends Transaccion {
    @Override
    void transaccionOk();

    @Override
    void transaccionNoOk();
}
