package Banco;

public class Basic extends Operacion implements IConsultaSaldo, IPagoServicio, IRetiroEfectivo {


    public void consultarSaldo()
    {
        boolean validar = true;
        if (validar)
            System.out.println( "Consultar Saldo: "+this.transaccionOk());
        else
            System.out.println( "Consultar Saldo: "+transaccionNoOk());
    }
    public void pagoServicio(){
        boolean validar = true;
        if (validar)
            System.out.println( "Pago Servicio: "+transaccionOk());
        else
            System.out.println( "Pago Servicio: "+transaccionNoOk());
    }
    public void retiroEfectivo(){
        boolean validar = true;
        if (validar)
            System.out.println( "Retiro Efectivo: "+transaccionOk());
        else
            System.out.println( "Retiro Efectivo: "+transaccionNoOk());
    }
}
