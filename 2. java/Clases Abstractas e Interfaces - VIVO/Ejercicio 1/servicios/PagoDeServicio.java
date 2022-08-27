package interfaces.servicios;

import interfaces.interfaz.Transaccion;

public class PagoDeServicio implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Se pago el servicio");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No Se pago el servicio");

    }
}
