public class Producto {
    private String nombre;
    private double precio;

    // Constructores
    public Producto(){

    }

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    // Métodos
    // toString
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + " - Precio: $" + this.precio + ".";
    }
    // calcular
    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos*this.precio;
    }
}
