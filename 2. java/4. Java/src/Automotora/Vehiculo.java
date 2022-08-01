package Automotora;

public class Vehiculo {

    private String Marca;
    private String Modelo;
    private Integer costo;

    public Vehiculo(String marca, String modelo, int costo) {
        Marca = marca;
        Modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
