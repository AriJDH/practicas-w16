package ejercicio1;

public class Ejecutivo implements Deposito,Transferencia{
    @Override
    public void hacerDeposito() {
        System.out.println("Realizando Deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion correcta");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion incorrecta");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Realizando transferencia");
    }
}
