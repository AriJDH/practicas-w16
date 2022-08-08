package distribuidora;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setDouble(double precio){
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Producto.";
    }

    public double calcular(int cantidadDeProductos){
        return (this.precio * cantidadDeProductos);
    }
}
