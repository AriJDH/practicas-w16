package com.bootcamp.agencia.entitiy;

public class BoletoViaje extends Reserva{

    public BoletoViaje(Double precio){
        super(precio);
    }

    @Override
    public String toString() {
        return "BoletoViaje: $" + precio;
    }
}
