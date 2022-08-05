package com.clases;

public class Transporte extends Producto{

    private String nombreTransporte;
    public String getNombreTransporte() {
        return nombreTransporte;
    }

    public void setNombreTransporte(String nombreTransporte) {
        this.nombreTransporte = nombreTransporte;
    }

    public Transporte(double valor, String nombreTransporte) {
        super(valor);
        this.nombreTransporte = nombreTransporte;
    }


}
