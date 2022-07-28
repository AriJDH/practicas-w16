package PooTwoExercises;

public class Producto {
    protected String nombre;
    protected double precio;

    /*
     * CONSTRUCTOR
     */

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /*
     * GETTERS
     */

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    /*
     * SETTERS
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        String producto = "Producto { " + "\n" +
                "Nombre: " + nombre + "\n" +
                "Precio: " + precio + "\n" +
                "}";

        return producto;
    }

    double calcular(int cantidadDeProductos) {
        return precio * cantidadDeProductos;
    }

}
