package recapitulandojava;

import java.math.BigDecimal;

public class Vehiculo {
    private String modelo;
    private String marca;
    private BigDecimal costo;

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

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public BigDecimal getCosto() {
        return costo;
    }
}
