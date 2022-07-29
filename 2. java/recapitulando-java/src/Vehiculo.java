public class Vehiculo {

    private final String modelo, marca;
    private final Double costo;

    public Vehiculo(String marca, String modelo, Double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Double getCosto() {
        return costo;
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
