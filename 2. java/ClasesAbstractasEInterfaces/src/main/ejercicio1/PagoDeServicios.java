package main.ejercicio1;

public class PagoDeServicios implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose pago de servicios");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el pago de servicios");
    }
}
