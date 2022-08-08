package clases.abstractas.interfaces.Ejercicio1;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo{
    @Override
    public void consultarSaldo(int cuenta, boolean resultado) {
        System.out.println("Consultando saldo de la cuenta " + cuenta);
        if (resultado) {
            transaccionOk("Consulta de Saldo");
        }else {
            transaccionNoOk("Consulta de Saldo");
        }
}

    @Override
    public void extraerEfectivo(int cuenta, double monto, boolean resultado) {
        System.out.println("Dispensando $" + monto + "de la cuenta " + cuenta);
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
