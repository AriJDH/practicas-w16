package com.banco;

public abstract class Montos {
    protected double saldos;

    public Montos(){

    }

    public Montos(double saldos) {
        this.saldos = saldos;
    }

    public double getSaldos() {
        return saldos;
    }

    public void setSaldos(double saldos) {
        this.saldos = saldos;
    }
}
