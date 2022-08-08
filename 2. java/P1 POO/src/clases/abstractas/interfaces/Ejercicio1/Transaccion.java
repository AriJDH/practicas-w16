package clases.abstractas.interfaces.Ejercicio1;

public interface Transaccion {

    public void transaccionOk(String nombreTransaccion);

    public void transaccionNoOk(String nombreTransaccion);
}
