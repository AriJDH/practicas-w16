package ejercicio1;

public class PagoServicio implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio NO realizado");

    }
}
