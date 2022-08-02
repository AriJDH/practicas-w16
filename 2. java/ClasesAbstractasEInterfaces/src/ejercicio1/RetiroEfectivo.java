package ejercicio1;

public class RetiroEfectivo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo NO realizado");
    }
}
