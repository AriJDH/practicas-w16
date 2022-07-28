package cliente;

import transacciones.ConsultaDeSaldo;
import transacciones.PagoDeServicio;
import transacciones.RetiroDeEfectivo;

public class Cobrador implements ConsultaDeSaldo, PagoDeServicio, RetiroDeEfectivo {
    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void realizarPagoDeServicio() {

    }

    @Override
    public void realizarRetiroDeEfectivo() {
        System.out.println("Realizando un retiro en efectivo");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion OK");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transaccion NO OK");

    }
}
