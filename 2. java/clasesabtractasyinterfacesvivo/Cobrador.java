package ejercicio1;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo{

    @Override
    public void consultarPago() {
        System.out.println("Cobrador consulto pago");
    }

    @Override
    public void hacerRetiro() {
        System.out.println("Cobrador realizo retiro");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Cobrador trasaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cobrador transaccion no OK");
    }
}
