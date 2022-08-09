package ejercicioBanco;

public class Transferencia implements ITransferencia {
    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia con errores");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia ok!");
    }
    public void enviarDinero() {
        System.out.println("Transferencia iniciada");
    }
}
