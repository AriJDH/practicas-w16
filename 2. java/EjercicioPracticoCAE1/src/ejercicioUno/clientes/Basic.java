package ejercicioUno.clientes;

import ejercicioUno.interfaces.ConsultaSaldo;
import ejercicioUno.interfaces.PagoServicios;
import ejercicioUno.interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void consultaSaldo(String cuenta) {
        System.out.println("el saldo de su cuenta es: $100.000");
        transaccionOk("Consulta Saldo");
    }

    @Override
    public void pagoServicios(String cuenta, double monto) {
        System.out.println("Se realizara el pago a la cuenta: "+cuenta+" con un monto de: "+monto);
        transaccionOk("Pago de Servicio");
    }

    @Override
    public void retiroEfectivo(double cantidad) {
        System.out.println("se retirara: "+cantidad);
        transaccionNoOk("Retiro Efectivo");
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
