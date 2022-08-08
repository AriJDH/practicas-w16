package clasesAbstractas_Interfaces.ejercicio_1.clases;

import clasesAbstractas_Interfaces.ejercicio_1.interfaces.ConsultaSaldo;
import clasesAbstractas_Interfaces.ejercicio_1.interfaces.PagoServicio;
import clasesAbstractas_Interfaces.ejercicio_1.interfaces.RetiroEfectivo;
import clasesAbstractas_Interfaces.ejercicio_1.interfaces.Transaccion;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {

    private boolean ok = false;

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
        if(!ok){
            transaccionOk("Consultar saldo");
        } else {
            transaccionNoOk("Consultar saldo");
        }

    }

    @Override
    public void pagarServicio(String servicio) {

        System.out.println("Pagando servicio: " + servicio);
        if(!ok){
            transaccionOk("Pagar servicio");
        } else {
            transaccionNoOk("Pagar servicio");
        }
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirando efectivo: " + monto);
        if(!ok){
            transaccionOk("Retirar efectivo");
        } else {
            transaccionNoOk("Retirar efectivo");
        }
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println(transaccion + " realizada con exito");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println(transaccion + " no pudo ser realizada");

    }
}
