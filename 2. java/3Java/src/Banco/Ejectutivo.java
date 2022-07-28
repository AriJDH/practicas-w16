package Banco;

public class Ejectutivo extends Operacion implements IDeposito, ITransferencia{
    @Override
    public void realizarDeposito() {
        boolean validar = true;
        if (validar)
            System.out.println( "Realizar Deposito: "+transaccionOk());
        else
            System.out.println( "Realizar Deposito: "+transaccionNoOk());
    }

    @Override
    public void transferencia() {
        boolean validar = true;
        if (validar)
            System.out.println( "Transferencia: "+transaccionOk());
        else
            System.out.println( "Transferencia: "+transaccionNoOk());
    }
}
