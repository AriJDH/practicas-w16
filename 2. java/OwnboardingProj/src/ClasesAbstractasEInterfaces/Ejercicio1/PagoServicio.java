package ClasesAbstractasEInterfaces.Ejercicio1;

public class PagoServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio No Ok");
    }
}
