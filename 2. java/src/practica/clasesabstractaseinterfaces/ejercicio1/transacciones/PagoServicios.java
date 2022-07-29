package practica.clasesabstractaseinterfaces.ejercicio1.transacciones;

import java.util.ArrayList;

public class PagoServicios implements Transactable {

    protected ArrayList<String> servicios;

    public PagoServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    @Override
    public void transaccionOK() {
        System.out.println("El pago se realizado exitosamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ha ocurrido un error durante la realizacion del pago.");
    }

    public void pagarServicio() {
        System.out.println("Realizando pago de servicio");
    }
}
