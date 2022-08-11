package Ejercicio1;

public class Basico extends ClienteBanco {

    public Basico(double saldo) {
        super(saldo);
    }

    public void retirar(double monto) {
        Retiro ret = new Retiro();
        saldo = ret.ejecutar(saldo, monto);
    }

    public void pagar(double monto) {
        PagoServicios ps = new PagoServicios();
        saldo = ps.ejecutar(saldo, monto);
    }

    public void consultar() {
        ConsultaSaldo c = new ConsultaSaldo();
        c.ejecutar(this.saldo);
    }
}
