package com.model;

import com.interfaz.IConsultaSaldo;
import com.interfaz.IRetiroEfectivo;

public class Cobrador extends Cliente implements IRetiroEfectivo, IConsultaSaldo {

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
        System.out.println("El saldo es $200.000");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Se ha retirado $200.000");
    }

}
