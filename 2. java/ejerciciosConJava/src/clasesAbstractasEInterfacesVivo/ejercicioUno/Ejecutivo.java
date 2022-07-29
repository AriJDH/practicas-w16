package clasesAbstractasEInterfacesVivo.ejercicioUno;

public class Ejecutivo implements Deposito,Transferencias{
    @Override
    public void hacerDeposito() {
        System.out.println("Cliente Ejecutivo haciendo deposito");
    }

    @Override
    public void hacerTransaccion() {
        System.out.println("Cliente Ejecutivo haciendo transacción");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Cliente Ejecutivo transacción realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cliente Ejecutivo no se pudo realizar la transacción");
    }


}
