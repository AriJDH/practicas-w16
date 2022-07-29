package clasesAbstractasEInterfacesVivo.ejercicioUno;

public class Basic implements ConsultaSaldo,PagoServicio,RetiroDeEfectivo{
    @Override
    public void consultasSaldo() {

        System.out.println("Cliente Basic consultando saldo");
    }

    @Override
    public void pagoServicio() {

        System.out.println("Cliente Basic pagando servicio");
    }

    @Override
    public void refiroDeEfectivo() {

        System.out.println("Cliente Basic retirando efectivo");
    }

    @Override
    public void transaccionOk() {

        System.out.println("Cliente Basic transacción realizada con exito");
    }

    @Override
    public void transaccionNoOk() {

        System.out.println("Cliente Basic no se pudo realizar la transacción");
    }
}
