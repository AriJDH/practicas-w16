package poo_p2_vivo;

public class Producto {
    private String nombre;
    private double precio;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: " + "nombre='" + nombre + '\'' + ", precio=" + precio;
    }

    public double calcular(int cantidadDeProductos) {
        return this.precio * cantidadDeProductos;
    }
}
