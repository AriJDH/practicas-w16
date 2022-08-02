package ejercicio1;

public class Transferencia implements Transaccion{


    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia NO realizada");
    }
}
