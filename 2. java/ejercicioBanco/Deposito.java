package ejercicioBanco;

public class Deposito implements IDeposito {
    @Override
    public void transaccionNoOk() {
        System.out.println("fallo en el deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("deposito ok");
    }

    @Override
    public void depositarEfectivo() {
        System.out.println("enviando dinero");
    }
}
