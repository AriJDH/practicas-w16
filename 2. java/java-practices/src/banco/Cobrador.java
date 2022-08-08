package banco;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo{
    @Override
    public void retiroDeEfectivo() {
        System.out.println("COBRADOR: realizando un retiro de efectivo.");
    }

    @Override
    public void consultaDeSaldo() {
        System.out.println("COBRADOR: realizando una consulta de saldo.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("COBRADOR: Transacción exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("COBRADOR: Transacción fallida. Vuelva a intentarlo.");
    }
}
