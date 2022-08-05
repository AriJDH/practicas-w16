package com.clases;

public class ReservaHotel extends Producto{

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public ReservaHotel(double valor, String nombreHotel) {
        super(valor);
        this.nombreHotel = nombreHotel;
    }

    private String nombreHotel;

}
