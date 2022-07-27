package POO.poo2;

public class Producto {

    protected String nombre;
    protected double precio;

    public Producto (String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
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

    public String toString(){
        return "Nombre: " + this.nombre + "\nPrecio: " + this.precio ;
    }

    public double calcular(int cantProductos){
        return cantProductos * this.precio ;
    }

}
