package main.ejercicio1;

public class Cobradores extends Clientes{
    private RetiroDeEfectivo unRetiroDeEfectivo;
    private ConsultaDeSaldo unaConsultaDeSaldo;
    void  realizarRetiroDeEfectivo(){
        unRetiroDeEfectivo.transaccionOk();
    }
    void realizarConsultaDeSaldos(){
        unaConsultaDeSaldo.transaccionOk();
    }
}
