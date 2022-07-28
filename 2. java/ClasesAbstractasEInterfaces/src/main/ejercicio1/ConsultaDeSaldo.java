package main.ejercicio1;

public class ConsultaDeSaldo implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose consulta de saldo");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la consulta de saldo");

    }
}
