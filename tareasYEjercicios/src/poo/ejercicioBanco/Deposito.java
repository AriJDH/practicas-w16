package poo.ejercicioBanco;

public class Deposito implements Transaccionable {

    @Override
    public void transaccionOk() {
        System.out.println("Se realizo deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el deposito");
    }
}
