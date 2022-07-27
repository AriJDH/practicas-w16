package herencia;

public class Producto {

    public String nombre;
    public double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String toString(){
        return "Info producto: \n Nombre: " + nombre + "\n Precio: " + precio;
    }

    public double calcular(int cantidadDeProductos){
        return precio * cantidadDeProductos;
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
