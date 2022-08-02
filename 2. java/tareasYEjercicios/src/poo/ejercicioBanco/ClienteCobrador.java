package poo.ejercicioBanco;

public class ClienteCobrador extends Cliente implements ConsultaDeSaldo, RetiroDeEfectivo {

    public ClienteCobrador(String nombre, String dni, String cbu) {
        super(nombre, dni, cbu);
    }


    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo ");
    }

    @Override
    public void retirarEfvo() {
        System.out.println("Retirando efectivo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al intentar realizar la transaccion");
    }
}
