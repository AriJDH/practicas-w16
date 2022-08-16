package MasAFondoDecorator;

public class Vehiculo  implements IVehiculo {
    private Double precio;
    private String modelo;
    private String accesorios;

    public Vehiculo(Double precio, String modelo, String accesorios) {
        this.precio = precio;
        this.modelo = modelo;
        this.accesorios = accesorios;
    }

    @Override
    public Double getPrecio() {
        return this.precio;
    }

    @Override
    public String getAccesorios() {
        return this.accesorios;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }
}
