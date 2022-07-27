package Ejercicio2;

public class Producto {

    protected String nombre;
    protected Double precio;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto(){

    }

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double Calcular(int cantidadDeProductos){
        return cantidadDeProductos*precio;
    }
}
