public class Vehiculo {
    private String modelo;
    private String marca;
    private Integer costo;

    public Vehiculo(String modelo, String marca, int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public Vehiculo() {
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

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo\n" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                "\n-----------------------------";
    }
}
