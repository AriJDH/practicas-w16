package banco;

public class Basic extends Cliente implements ConsultaDeSaldo, RetiroDeEfectivo, PagoDeServicios{
    @Override
    public void consultaDeSaldo() {
        System.out.println("El Básico está haciendo consulta de saldo");
    }

    @Override
    public void pagoDeServicios() {
        System.out.println("El Básico está haciendo pago de servicios.");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("El Básico está retirando efectivo.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("BASIC: Transacción exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("BASIC: Transacción no exitosa.");
    }
}
