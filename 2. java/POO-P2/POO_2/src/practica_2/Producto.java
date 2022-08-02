package practica_2;

public class Producto {
    String nombre;
    double precio;

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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Nombre : " + nombre + "\n" +
                "Precio : " + precio + "\n";
    }

    double calcular(int cantidadProductos){
         return this.precio * cantidadProductos;
    }

}
