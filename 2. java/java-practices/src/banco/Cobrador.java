package banco;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo{

    @Override
    public void consultaDeSaldo() {
        System.out.println("El Cobrador está consultando saldo.");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("El Cobrador está retirando efectivo.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("EXITOSA");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("NO EXITOSA");
    }
}
