package com.clases;

public abstract class Producto {
    protected double valor;

    public Producto(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
