package Ejercicio1;

public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo {

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion aprobada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion rechazada");
    }
}
