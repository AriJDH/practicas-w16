package banco;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo{

    @Override
    public void transaccionOK() {
        System.out.println("Transacción realizada con éxito");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transacción no realizada");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponible : 33000");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Servicios pagados");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Operación realizada con éxito");
    }
}
