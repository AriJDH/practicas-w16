package Distribuidora;

public class Producto {
    private String nombre;
    private double precio;

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Distribuidora.Producto{" + "nombre='" + nombre + '\'' + ", precio=" + precio + '}';
    }

    double calcular(int cantidad) {
        return this.precio * cantidad;
    }
}
