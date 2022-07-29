package practica.poo.p2.vivo;

public class NoPerecedero extends Producto {

    protected String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + this.nombre + '\'' +
                ", precio=" + this.precio +
                ", tipo=" + this.tipo +
                '}';
    }
}
