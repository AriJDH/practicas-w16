package com.clases;

public class Comida extends Producto{
    private String nombrePlato;

    public Comida(double valor, String nombrePlato) {
        super(valor);
        this.nombrePlato = nombrePlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
}
