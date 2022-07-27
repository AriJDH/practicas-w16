public class NoPerecedero extends Producto {
    String tipo;

    // Constructores
    public NoPerecedero() {

    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    // Setters

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Métodos
    // Calcular funciona igual que la super clase Producto
    // toString
    @Override
    public String toString() {
        return "NoPerecedero{" +
                "nombre=" + getNombre() +
                "precio= " + getPrecio() +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
