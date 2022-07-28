package Banco;

public class Cobrador extends Operacion implements IRetiroEfectivo, IConsultaSaldo{

    public void retiroEfectivo(){
        boolean validar = true;
        if (validar)
            System.out.println( "Retiro Efectivo: "+transaccionOk());
        else
            System.out.println( "Retiro Efectivo: "+transaccionNoOk());
    }
    public void consultarSaldo()
    {
        boolean validar = true;
        if (validar)
            System.out.println( "Consultar Saldo: "+transaccionOk());
        else
            System.out.println( "Consultar Saldo: "+transaccionNoOk());
    }
}
