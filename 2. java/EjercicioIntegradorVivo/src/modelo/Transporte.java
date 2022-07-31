package modelo;

public class Transporte implements Reserva{
    private int dias;
    private String descripcion;
    private final double precio;

    public Transporte(int dias, String descripcion, double precio) {
        this.dias = dias;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
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

    @Override
    public String toString() {
        return "Transporte{" +
                "dias=" + dias +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double darPrecio() {
        return this.dias*this.precio;
    }

    @Override
    public String tipo() {
        return "transporte";
    }
}
