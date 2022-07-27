package Clases;

public class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio){
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

    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos*precio;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\tPrecio unitario: " + precio;
    }


}
