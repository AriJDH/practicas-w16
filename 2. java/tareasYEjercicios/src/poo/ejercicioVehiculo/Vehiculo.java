package poo.ejercicioVehiculo;

public class Vehiculo {

    private String marca;
    private String modelo;
    private Integer precio;

    public Vehiculo(String modelo, String marca, Integer precio) {
        this.marca = modelo;
        this.modelo = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\nMarca: " + marca + ", " +
                "Modelo: " + modelo + ", " +
                "Precio: " + precio;
    }
}
