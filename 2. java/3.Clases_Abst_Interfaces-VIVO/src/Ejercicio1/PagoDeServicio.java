package Ejercicio1;

public class PagoDeServicio implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println(" - Se realizo el pago de sus servicios. \n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(" - No se realizo el pago de sus servicios. \n");
    }
}
