package Ejercicio1;

public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo{
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        System.out.println("Sin saldo :(");
    }

    @Override
    public void retirarEfectivo(double cantidad) {
        this.transaccionNoOk("retiro");
        System.out.println("Solo tiene " + (cantidad-1) + " disponibles en su cuenta.");

    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("Su transaccion " + tipoTransaccion + " ha sido realizada de manera exitosa.");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("Transaccion: " + tipoTransaccion + " no se ha podido realizar.");
    }
}
