package main.ejercicio1;

public class RetiroDeEfectivo implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro de efectivo");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar retiro de efectivo");

    }
}
