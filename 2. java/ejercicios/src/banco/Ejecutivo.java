package banco;

public class Ejecutivo extends Cliente implements Deposito, Transferencia{
    @Override
    public void depositar() {
        System.out.println("Depósito realizado con éxito");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Transacción realizada con éxito");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transacción no realizada");
    }

    @Override
    public void transferir() {
        System.out.println("Se realizó la transferencia correctamente");
    }
}
