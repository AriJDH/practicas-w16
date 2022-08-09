package Distribuidora;

public class NoPerecedero extends Producto {
    String tipo;

    NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Distribuidora.Perecedero{" +
                "nombre='" + this.getNombre() + '\'' +
                ", precio=" + this.getPrecio() +'\'' +
                "diasPorCaducar=" + this.getTipo() +
                '}';
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
