package practicaEnVivo;

public class Basic {
    ConsultaSaldo c;
    PagoServicio p;
    RetiroEfectivo r;

    public Basic (){
        c = new ConsultaSaldo();
        p = new PagoServicio();
        r = new RetiroEfectivo();
    }

    public void consultarSaldo(){
        c.transaccionOK();
    }

    public void pagarServicio(){
        p.transaccionOK();
    }

    public void retirarEfectivo(){
        r.transaccionOK();
    }
}
