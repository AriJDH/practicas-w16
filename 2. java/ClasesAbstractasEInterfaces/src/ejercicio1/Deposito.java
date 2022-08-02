package ejercicio1;

public class Deposito implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito NO realizado");
    }
}
