package ejercicioUno.clientes;

import ejercicioUno.interfaces.Deposito;
import ejercicioUno.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void deposito(double cantidad) {
        System.out.println("Se va a Depositar: $"+cantidad);
        transaccionNoOk("Deposito");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("Transaccion "+tipoTransaccion+" fue exitoso");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("Transaccion: "+tipoTransaccion+" declinada");
    }

    @Override
    public void transferencia(double cantidad) {
        System.out.println("Se va a Transferir: $"+cantidad);
        transaccionOk("Transferencia");
    }
}
