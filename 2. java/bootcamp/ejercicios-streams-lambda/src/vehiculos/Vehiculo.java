package vehiculos;

public class Vehiculo {

    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(){}

    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehículo: \n" + "-Marca: " + marca+ "\n-Modelo: " +modelo+ "\n-Precio: " + costo;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
