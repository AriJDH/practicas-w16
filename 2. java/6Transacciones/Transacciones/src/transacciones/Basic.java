package transacciones;

import transaccInterfaces.ConsultaSaldo;
import transaccInterfaces.PagoDeServicios;
import transaccInterfaces.RespuestaTransaccion;
import transaccInterfaces.RetiroDeEfectivo;

public class Basic implements ConsultaSaldo, PagoDeServicios, RetiroDeEfectivo, RespuestaTransaccion {


    @Override
    public void procesoDeConsulta() {

        System.out.println("Consultando Saldo Basic...");

        boolean ok=false;

        if(ok){
            transaccionOK("Consulta de saldo exitosa. Basic");
        }else {
            transaccionNoOK("Consulta de saldo fallida . Basic");
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

    @Override
    public void procesoPagoDeServicios() {

        System.out.println("Pagando servicio Basic...");

        boolean ok=true;

        if(ok){
            transaccionOK("Pago de Servicio Basic realizado");
        }else {
            transaccionNoOK("Pago de Servicio Basic no realizado");
        }
    }



    @Override
    public void procesoRetiroDeEfectivo() {

        System.out.println("Retirando Efectivo Basic...");

        boolean ok=true;

        if(ok){
            transaccionOK("Consulta de retiro ok. Basic");
        }else {
            transaccionNoOK("Consulta de retiro fallida. Basic");
        }
    }
}
