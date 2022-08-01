package cliente;

import transacciones.ConsultaDeSaldo;
import transacciones.RetiroDeEfectivo;

public class Ejecutivo implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Realizando una consulta de saldo");
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        System.out.println("Realizando un retiro de efectivo");
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
