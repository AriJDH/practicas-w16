package Ejercicio1;

public class Ejecutivo extends ClienteBanco{

    public Ejecutivo(double saldo){
        super(saldo);
    }

    public void depositar(double monto){
        Deposito d = new Deposito();
        saldo = d.ejecutar(saldo, monto);
    }

    public void transferir(double monto){
        Transferencia t = new Transferencia();
        t.ejecutar(saldo, monto);
    }
}
