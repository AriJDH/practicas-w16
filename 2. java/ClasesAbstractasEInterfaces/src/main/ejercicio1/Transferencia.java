package main.ejercicio1;

public class Transferencia implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar transferencia");

    }
}
