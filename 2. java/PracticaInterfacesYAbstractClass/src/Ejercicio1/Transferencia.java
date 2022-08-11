package Ejercicio1;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOK() {
        System.out.println("Transferencia realizada con exito.");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Error al transferir");
    }

    public double ejecutar(double saldo, double monto)
    {
        if((saldo - monto) > 0){
            transaccionOK();
            return saldo - monto;
        }
        else{
            transaccionNoOK();
            return saldo;
        }
    }
}
