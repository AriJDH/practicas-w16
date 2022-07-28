package main.ejercicio1;

public class Deposito implements Transacciones{

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el depósito");
    }
}
