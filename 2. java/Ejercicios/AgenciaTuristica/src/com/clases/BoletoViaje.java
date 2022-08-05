package com.clases;

public class BoletoViaje extends Producto{

    private String destino;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BoletoViaje(double valor, String destino) {
        super(valor);
        this.destino = destino;
    }
}
