package EjercicioDos;

public class NoPerecedero extends  Producto{
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String toString()
    {
        return  "Nombre: "+this.getNombre()+" Tipo: "+this.tipo+" Precio: "+this.getPrecio();
    }
}
