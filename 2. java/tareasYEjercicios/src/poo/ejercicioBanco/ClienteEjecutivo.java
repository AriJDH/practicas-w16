package poo.ejercicioBanco;

public class ClienteEjecutivo extends Cliente implements Deposito, Transferencia {

    public ClienteEjecutivo(String nombre, String dni, String cbu) {
        super(nombre, dni, cbu);
    }

    @Override
    public void depositar() {
        System.out.println("Se realizo el deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al intentar realizar la transaccion");
    }

    @Override
    public void transferir() {
        System.out.println("Se realizo transaccion");
    }
}
