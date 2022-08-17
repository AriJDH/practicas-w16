package transacciones;

import transaccInterfaces.Deposito;
import transaccInterfaces.RespuestaTransaccion;
import transaccInterfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia, RespuestaTransaccion {


    @Override
    public void transaccionOK(String msg) {
        System.out.println(msg);
    }

    @Override
    public void transaccionNoOK(String msg) {
        System.out.println(msg);

    }

    @Override
    public void procesoDeDeposito() {
        System.out.println("Deposito de Ejecutivo ...");

        boolean ok=true;

        if(ok){
            transaccionOK("Deposito realizado");
        }else {
            transaccionNoOK("Deposito NO realizado");
        }
    }

    @Override
    public void procesoDeTransferencia() {
        System.out.println("Transferencia de Ejecutivo ...");

        boolean ok=true;

        if(ok){
            transaccionOK("Transferencia realizada");
        }else {
            transaccionNoOK("Transferencia NO realizada");
        }
    }
}
