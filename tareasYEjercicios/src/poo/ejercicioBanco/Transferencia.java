package poo.ejercicioBanco;

public class Transferencia implements Transaccionable {

    @Override
    public void transaccionOk() {
        System.out.println("Se realizo transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo transferencia");
    }
}
