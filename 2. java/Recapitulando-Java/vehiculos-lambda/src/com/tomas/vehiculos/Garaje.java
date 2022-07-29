package com.tomas.vehiculos;

import java.util.List;

public class Garaje {

    private int identificador;
    private List<Vehiculo> listaVehiculo;

    public Garaje(int identificador, List<Vehiculo> listaVehiculo) {
        this.identificador = identificador;
        this.listaVehiculo = listaVehiculo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "identificador=" + identificador +
                ", listaVehiculo=" + listaVehiculo +
                '}';
    }
}
