package Practicaproductos;

public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio;}

    public void setPrecio(double precio) { this.precio = precio; }

    public double calcular(int cantidadDeProductos) {

    double total = 0.0;

    total = this.precio * cantidadDeProductos;

    return total;

    }

    @Override
    public String toString(){
        return "El producto es : " + this.nombre + " y su precio es de: $"+this.precio;
    }

}
