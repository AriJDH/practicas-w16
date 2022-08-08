package clases.abstractas.interfaces.Ejercicio1;

public interface Transferencia extends Transaccion{

public void realizarTansferencia(int cuentaOrigen, int cuentaDestino, double monto, boolean resultado);
}
