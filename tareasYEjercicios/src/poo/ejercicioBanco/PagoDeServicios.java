package poo.ejercicioBanco;

public class PagoDeServicios implements Transaccionable {


    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el pago");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo el pago");
    }
}
