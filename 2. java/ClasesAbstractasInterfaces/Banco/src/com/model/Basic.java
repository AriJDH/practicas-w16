package com.model;

import com.interfaz.IConsultaSaldo;
import com.interfaz.IPagoServicios;
import com.interfaz.IRetiroEfectivo;

public class Basic extends Cliente implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo {

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no realizada");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("El saldo es $100.000");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Se han pagado todos los servicios");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Se ha retirado $140.000");
    }


}
