package com.clases;

import java.util.List;

public class Vehiculo {
    private Integer id;
    private String modelo, marca;
    private Double costo;

    public Vehiculo(Integer id, String modelo, String marca, Double costo) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo {" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                "}\n";
    }
}
