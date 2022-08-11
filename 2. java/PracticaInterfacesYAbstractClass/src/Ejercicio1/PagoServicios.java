package Ejercicio1;

public class PagoServicios implements ITransaccion{
    @Override
    public void transaccionOK() {
        System.out.println("Pago realizado con exito.");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Error al pagar, no tiene saldo suficiente");
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
