package ejercicioBanco;

public class PagoServicios implements IPagoServicio {
    @Override
    public void transaccionNoOk() {
        System.out.println("Servicio no pagado");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Servicio pago!");
    }

    @Override
    public void pagar() {
        System.out.println("Pagando su servicio");
    }
}
