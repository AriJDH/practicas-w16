package EjercicioDos;

public class Producto {
    private String Nombre;
    private double Precio;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }



    public Producto( String nombre, double precio) {
        Nombre = nombre;
        Precio = precio;
    }
    public double calcular(int cantidad)
    {
        return this.Precio*cantidad;
    }

    public String toString()
    {
        return " Nombre: "+this.Nombre+" Precio: "+this.Precio;
    }
}
