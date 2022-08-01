package p2vivo;

public class Producto {
    private String nombre;
    private double precio;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double calcular( int cantidadDeProductos) {
        return this.precio * cantidadDeProductos;
    }
}
