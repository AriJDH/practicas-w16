package Ejercicio1;

public class Basic extends Cliente {

    public Basic(String name, String dni, String clientType) {
        super(name, dni, clientType);
    }

    ConsultaDeSaldo saldo = new ConsultaDeSaldo();
    PagoDeServicio pagoServicio = new PagoDeServicio();
    RetiroDeEfectivo retiroEfectivo = new RetiroDeEfectivo();

    public void saldo(){
        saldo.transaccionOk();
    }

    public void pagoServicio(){
        pagoServicio.transaccionNoOk();
    }

    public void retiroEfectivo(){
        retiroEfectivo.transaccionOk();
    }
}
