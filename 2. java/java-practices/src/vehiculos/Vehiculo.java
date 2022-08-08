package vehiculos;

public class Vehiculo {
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(){
        this.modelo = "";
        this.marca = "";
        this.costo = 0.0;
    }

    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String toString(){
        return ("MODELO: " + this.modelo + ", MARCA: " + this.marca + ", COSTO: $" + this.costo);
    }
}
