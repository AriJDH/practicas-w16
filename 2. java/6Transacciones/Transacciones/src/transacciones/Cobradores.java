package transacciones;

import transaccInterfaces.ConsultaSaldo;
import transaccInterfaces.RespuestaTransaccion;
import transaccInterfaces.RetiroDeEfectivo;

public class Cobradores implements RetiroDeEfectivo, ConsultaSaldo, RespuestaTransaccion {

    @Override
    public void procesoDeConsulta() {
        System.out.println("Consultando...");

        boolean ok=false;

        if(ok){
            transaccionOK("Consulta efectiva. Cobradores");
        }else {
            transaccionNoOK("Consulta fallida. Cobradores");
        }
    }

    @Override
    public void procesoRetiroDeEfectivo() {

        System.out.println("Retiro de Efectivo...");

        boolean ok=true;

        if(ok){
            transaccionOK("Retiro realizado. Cobradores");
        }else {
            transaccionNoOK("Retiro fallido. Cobradores");
        }

    }


    @Override
    public void transaccionOK(String msg) {
        System.out.println(msg);
    }

    @Override
    public void transaccionNoOK(String msg) {
        System.out.println(msg);
    }
}
