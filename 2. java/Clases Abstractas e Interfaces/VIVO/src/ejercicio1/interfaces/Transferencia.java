package ejercicio1.interfaces;

public interface Transferencia extends Transaccion {

    void realizarTransferencia(int nroCuenta, double importe);

}
