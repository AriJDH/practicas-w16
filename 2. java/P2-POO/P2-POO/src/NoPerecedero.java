public class NoPerecedero extends Producto{
    private static String tipo;

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        NoPerecedero.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{Nombre del producto=" + getNombre() + " " + " precio: " + getPrecio() + "tipo de producto"+ tipo + "}";
    }

}
