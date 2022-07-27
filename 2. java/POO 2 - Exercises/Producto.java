/*
 *
 * Crear una clase Producto que cuente con los siguientes atributos: String nombre y double precio, la misma debe definir los métodos getters y setters para sus atributos, 
 *  un constructor que reciba todos sus atributos como parámetro y el método toString(). Crear el método calcular() al
 *  cual vamos a pasarle un parámetro de tipo int llamado cantidadDeProductos; este método tiene que multiplicar el precio por la cantidad de productos pasados.
 */

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
