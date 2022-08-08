package poo.p2_vivo.ejercicio2;

public class Producto {

    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, double precio) {
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

    public String toString() {
        return "Nombre Producto: "+ this.nombre + "\nPrecio Producto: " + this.precio;
    }

    public double calcular(int cantidadDeProductos) {
        double total = this.precio*cantidadDeProductos;
        return  total;
    }
}
