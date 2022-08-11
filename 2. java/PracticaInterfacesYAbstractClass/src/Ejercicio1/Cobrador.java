package Ejercicio1;

public class Cobrador extends ClienteBanco{

    public Cobrador(double saldo){
        super(saldo);
    }

    public void retirar(double monto) {
        Retiro ret = new Retiro();
        if((this.saldo - monto) > 0)
            ret.transaccionOK();
        else
            ret.transaccionNoOK();
    }

    public void consultar() {
        ConsultaSaldo c = new ConsultaSaldo();
        c.ejecutar(this.saldo);
    }
}
