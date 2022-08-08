package clasesAbstractas_Interfaces.ejercicio_1.clases;

import clasesAbstractas_Interfaces.ejercicio_1.interfaces.Deposito;
import clasesAbstractas_Interfaces.ejercicio_1.interfaces.Transaccion;
import clasesAbstractas_Interfaces.ejercicio_1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    private boolean ok = true;

    @Override
    public void realizarDeposito() {

        System.out.println("Realizando deposito");
        if(!ok){
            transaccionOk("Dealizar deposito");
        } else {
            transaccionNoOk("Realizar deposito");
        }

    }

    @Override
    public void realizarTransferencia(Double montoTransf) {

        System.out.println("Realizando transferencia por: " + montoTransf);
        if(!ok){
            transaccionOk("Realizar transferencia");
        } else {
            transaccionNoOk("Realizar transferencia");
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
