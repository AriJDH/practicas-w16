package clasesAbstractasEInterfacesVivo.ejercicioUno;

public class Cobrador implements RetiroDeEfectivo,ConsultaSaldo{

    @Override
    public void consultasSaldo() {

        System.out.println("Cliente Cobrador consultando el saldo");
    }

    @Override
    public void refiroDeEfectivo() {

        System.out.println("Cliente Cobrador retirando efectivo");
    }

    @Override
    public void transaccionOk() {

        System.out.println("Cliente Cobrador transacción realizada con exito");
    }

    @Override
    public void transaccionNoOk() {

        System.out.println("Cliente Cobrador no se pudo realizar la transacción");
    }
}
