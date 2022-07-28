package ejercicioUno.clientes;

import ejercicioUno.interfaces.ConsultaSaldo;
import ejercicioUno.interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void consultaSaldo(String cuenta) {
        System.out.println("el saldo de su cuenta es: $100.000");
        transaccionOk("Consulta Saldo");
    }

    @Override
    public void retiroEfectivo(double cantidad) {
        System.out.println("Se va a retirar: $"+cantidad);
        transaccionOk("Retiro Efectivo");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("Transaccion "+tipoTransaccion+" fue exitoso");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("Transaccion: "+tipoTransaccion+" declinada");
    }
}
