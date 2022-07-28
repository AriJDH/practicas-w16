package main.ejercicio1;

public class Basic extends Clientes{
    private ConsultaDeSaldo unaConsultaDeSaldo;
    private PagoDeServicios unPagoDeServicios;
    private RetiroDeEfectivo unRetiroDeEfectivo;

     void realizarConsultaDeSaldo(){
         unaConsultaDeSaldo.transaccionOk();
     }
    void pagosDeServicios(){
        unPagoDeServicios.transaccionOk();
    }
    void retiroDeEfectivo(){
        unRetiroDeEfectivo.transaccionOk();

    }
}
