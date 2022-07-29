package Streams.models;

import java.math.BigDecimal;

public class Vehiculo {
    private String modelo;
    private String marca;
    private BigDecimal costo;

    public Vehiculo() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Vehiculo(String modelo, String marca, BigDecimal costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
