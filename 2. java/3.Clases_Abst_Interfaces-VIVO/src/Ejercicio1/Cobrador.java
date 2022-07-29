package Ejercicio1;

public class Cobrador extends Cliente {

    public Cobrador(String name, String dni, String clientType) {
        super(name, dni, clientType);
    }

    ConsultaDeSaldo saldo = new ConsultaDeSaldo();
    RetiroDeEfectivo retiroEfectivo = new RetiroDeEfectivo();

    public void saldo(){
        saldo.transaccionOk();
    }

    public void retiroEfectivo(){
        retiroEfectivo.transaccionOk();
    }
}
