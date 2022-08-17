package com.bootcamp.agencia.entitiy;

public class Hotel extends Reserva{

    public Hotel(Double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Hotel: $" + precio;
    }
}
