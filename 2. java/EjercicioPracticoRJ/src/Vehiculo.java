public class Vehiculo {

    private String modelo;
    private double costo;
    private String marca;

    public Vehiculo() {
    }

    public Vehiculo(String modelo, double costo, String marca) {
        this.modelo = modelo;
        this.costo = costo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", costo=" + costo +
                ", marca='" + marca + '\'' +
                '}';
    }
}
