package Ejercicios3;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.nombre + " Precio: " + this.precio;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos){
        return this.precio * cantidadDeProductos;
    }
}
