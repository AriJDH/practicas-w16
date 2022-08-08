package clases.abstractas.interfaces.Ejercicio1;

public class Ejecutivo implements Deposito, Transferencia{
    @Override
    public void realizarDeposito(int cuentaDestino, double monto, boolean resultado) {
        System.out.println("Depositando $" + monto + " a la cuenta " + cuentaDestino);
        if (resultado) {
            transaccionOk("Retiro de Efectivo");
        }else {
            transaccionNoOk("Retiro de Efectivo");
        }
    }

    @Override
    public void realizarTansferencia(int cuentaOrigen, int cuentaDestino, double monto, boolean resultado) {
        System.out.println("Transfiriendo $" + monto + " desde la cuenta " + cuentaOrigen + "a la cuenta " + cuentaDestino);
        if (resultado) {
            transaccionOk("Retiro de Efectivo");
        }else {
            transaccionNoOk("Retiro de Efectivo");
        }
    }

    @Override
    public void transaccionOk(String nombreTransaccion) {
        System.out.println("La transaccion " + nombreTransaccion + " finalizó correctamente");
    }

    @Override
    public void transaccionNoOk(String nombreTransaccion) {
        System.out.println("La transaccion " + nombreTransaccion + " finalizó de forma incorrecta");
    }

}
