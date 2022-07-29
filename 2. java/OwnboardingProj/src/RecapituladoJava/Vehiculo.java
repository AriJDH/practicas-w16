package RecapituladoJava;

public class Vehiculo {
    private String modelo;
    private String marca;
    private Double costo;

    public Vehiculo(String modelo, String marca, Double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(Double costo) {
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
                '}' + '\'';
    }
}
