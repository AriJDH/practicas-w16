package Ejercicios1;

public class Basic implements ConsultarSaldo, PagoDeServicios, RetiroDeEfectivo{

    private double saldoFake = 100;

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo: " + saldoFake);
    }

    @Override
    public void pagarServicios(double monto) {
        System.out.println("Pagar servicios: " + monto);
    }

    @Override
    public void retirarEfectivo(double monto) {
        System.out.println("Retirar efectivo: " + monto);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO OK");
    }
}
