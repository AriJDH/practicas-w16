package JavaEjercicioIntegradoP2PG;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidad;
    private int costo;

    public Item() {
    }

    public Item(int codigo, String nombre, int cantidad, int costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                '}';
    }
}
