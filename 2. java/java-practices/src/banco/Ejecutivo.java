package banco;

public class Ejecutivo extends Cliente implements Deposito, Transferencia{
    @Override
    public void transaccionOk() {
        System.out.println("EJECUTIVO: Transaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("EJECUTIVO: Transaccion no exitosa.");
    }

    @Override
    public void deposito() {
        System.out.println("El Ejecutivo está depositando.");
    }

    @Override
    public void transferencia() {
        System.out.println("El ejecutivo está haciendo una transferencia.");
    }
}
