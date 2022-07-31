public class Vehiculo {

    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String modelo, String marca,double costo)
    {
        this.costo=costo;
        this.marca=marca;
        this.modelo=modelo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCosto() {
        return costo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +"\n"+
                '}';
    }
}


