package Entity;

import Interface.Efectivo;
import Interface.Saldo;
import Interface.Servicios;

public class Basic extends Cliente implements Efectivo, Saldo, Servicios {

    @Override
    public void retiro_Efectivo() {
        System.out.println("Retirando efectivo el basic");
    }

    @Override
    public void consulta_Saldo() {
        System.out.println("consultando saldo el basic");
    }

    @Override
    public void pago_servicio() {
        System.out.println("pagando servicio el basic");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion rechazada del basic");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion rechazada del basic");
    }
}
