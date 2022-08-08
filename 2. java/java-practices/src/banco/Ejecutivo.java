package banco;

public class Ejecutivo extends Cliente implements Deposito, Transferencia{
    @Override
    public void deposito() {
        System.out.println("EJECUTIVO: realizando un depósito.");
    }

    @Override
    public void transferencia() {
        System.out.println("EJECUTIVO: realizando una transferencia.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("EJECUTIVO: Transacción exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("EJECUTIVO: Transacción fallida. Vuelva a intentarlo.");
    }
}
