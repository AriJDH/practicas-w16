package practicaEnVivo;

public class PagoServicio implements Transaccion{
    public PagoServicio(){}

    @Override
    public void transaccionOK() {
        System.out.println("Pago Servicio OK");
    }

    @Override
    public void transaccionNOOK() {
        System.out.println("Pago Servicio NO OK");
    }
}
