package clasesAbstractas_Interfaces.ejercicio_1.clases;

import clasesAbstractas_Interfaces.ejercicio_1.interfaces.ConsultaSaldo;
import clasesAbstractas_Interfaces.ejercicio_1.interfaces.RetiroEfectivo;
import clasesAbstractas_Interfaces.ejercicio_1.interfaces.Transaccion;

public class Cobrador implements ConsultaSaldo, RetiroEfectivo {

    private boolean ok = true;

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
