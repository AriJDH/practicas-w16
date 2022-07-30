package Clientes;

import Transacciones.Consulta;
import Transacciones.RetiroEfectivo;
import Transacciones.Transaccion;

public class Cobrador extends Cliente implements RetiroEfectivo, Consulta {

    @Override
    public void consulSaldo() {
        System.out.println("Consultando Saldo...");
        if(Math.random() < 0.2)
            Transaccion.transaccionNoOk("Consulta de Saldo");
        else {
            System.out.printf("Su saldo es de: $%.2f.", Math.random()*10E6);
            Transaccion.transaccionOk("Consulta de Saldo");
        }
    }

    @Override
    public void hacerRetiro() {
        System.out.println("Retirando efectivo...");

        if(Math.random() < 0.6)
            Transaccion.transaccionNoOk("Retiro de Efectivo");
        else Transaccion.transaccionOk("Retiro de Efectivo");
    }

}
