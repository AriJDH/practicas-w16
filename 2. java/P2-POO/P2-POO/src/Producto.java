public class Producto {
    private static String nombre;
    private static double precio;

    public static String getNombre() {
        return nombre;
    }

    public static double getPrecio() {
        return precio;
    }

    public static void setNombre(String nombre) {
        Producto.nombre = nombre;
    }

    public static void setPrecio(double precio) {
        Producto.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos){
        return precio * cantidadDeProductos;
    }
    @Override
    public String toString() {
        return "{Nombre del producto=" + nombre + " " + " precio: " + precio + "}";
    }
}
