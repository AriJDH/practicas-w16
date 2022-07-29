package ExerciseOne.actors;

public class Vehiculo {
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String marca, String modelo, double costo) {
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

    @Override
    public String toString() {
        return "Vehiculo [ marca=" + this.marca + ", modelo=" + this.modelo +  ", costo=" + this.costo + "]";
    }

}
