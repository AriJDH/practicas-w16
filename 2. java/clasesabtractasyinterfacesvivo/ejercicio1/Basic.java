package ejercicio1;

public class Basic implements ConsultaDeSaldo, PagoDeServicio, RetiroDeEfectivo{
    @Override
    public void consultarPago() {
        System.out.println("Basic consulta pago");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Basic pago servicio");
    }

    @Override
    public void hacerRetiro() {
        System.out.println("Basic Retiro dinero");
    }

    @Override
    public void transaccionOk() {
        System.out.println(" Basic trasaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(" Basic trasaccion No OK");
    }
}
