public class Producto  {
    String nombre;
    double precio;

    //Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Constructor


    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //método toString
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular(int cantidadDeProductos){
        return this.precio * cantidadDeProductos;
    }
}
