package practicaEnVivo;

public class Cobradores {
    RetiroEfectivo r;
    ConsultaSaldo c;

    public Cobradores(){
        r = new RetiroEfectivo();
        c = new ConsultaSaldo();
    }

    public void retirarEfectivo(){
        r.transaccionOK();
    }

    public void consultarSaldo(){
        c.transaccionOK();
    }
}
