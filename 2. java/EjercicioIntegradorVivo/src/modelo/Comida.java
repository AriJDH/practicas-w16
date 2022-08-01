package modelo;

public class Comida implements Reserva{

    private String descripcion;
    private final double precio;
    private int cantidad;

    public Comida(String descripcion, double precio, int cantidad) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public double darPrecio() {
        return this.precio*this.cantidad;
    }

    @Override
    public String tipo() {
        return "comida";
    }
}
