package Ejercicios1;

public class Cobrador implements RetiroDeEfectivo, ConsultarSaldo{
    private double saldoFake = 100;

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo: " + saldoFake);
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
