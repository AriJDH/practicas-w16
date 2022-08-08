package banco;

public class Basic extends Cliente implements ConsultaDeSaldo, RetiroDeEfectivo, PagoDeServicios{
    @Override
    public void consultaDeSaldo() {
        System.out.println("BASIC: realizando una consulta de saldo.");
    }

    @Override
    public void pagoDeServicios() {
        System.out.println("BASIC: realizando un pago de servicios.");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("BASIC: realizando un retiro de efectivo.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("BASIC: Transacción exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("BASIC: Transacción fallida. Vuelva a intentarlo.");
    }
}
