package interfaces.servicios;

import interfaces.interfaz.Transaccion;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado con exito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el retiro");
    }
}
