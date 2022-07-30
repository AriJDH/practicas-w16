package Clientes;

import Transacciones.Consulta;
import Transacciones.PagoServicios;
import Transacciones.RetiroEfectivo;
import Transacciones.Transaccion;

public class Basic extends Cliente implements Consulta, PagoServicios, RetiroEfectivo {

    @Override
    public void consulSaldo() {
        System.out.println("Consultando Saldo...");
        if(Math.random() < 0.3)
            Transaccion.transaccionNoOk("Consulta de Saldo");
        else {
            System.out.printf("Su saldo es de: $%.2f.", Math.random()*10E5);
            Transaccion.transaccionOk("Consulta de Saldo");
        }
    }

    @Override
    public void hacerPago() {
        System.out.println("Realizando Pago de Servicio...");
        if(Math.random() < 0.4)
            Transaccion.transaccionNoOk("Pago de Servicio");
        else Transaccion.transaccionOk("Pago de Servicio");
    }

    @Override
    public void hacerRetiro() {
        System.out.println("Retirando efectivo...");

        if(Math.random() < 0.75)
            Transaccion.transaccionNoOk("Retiro de Efectivo");
        else Transaccion.transaccionOk("Retiro de Efectivo");
    }

}
