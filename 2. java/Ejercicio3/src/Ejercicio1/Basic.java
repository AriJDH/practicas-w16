package Ejercicio1;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo{

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion aprobada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion rechazada");
    }
}
