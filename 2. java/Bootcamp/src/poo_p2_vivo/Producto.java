package poo_p2_vivo;

public class Producto {
    protected String nombre;
    protected double precio;

    @Override
    public String toString() {
        return "Producto:\n" +
                "\t-Nombre: " + nombre +
                "\n\t-Precio: $" + precio +
                '\n';
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos){
        return this.precio * cantidadDeProductos;
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
}
