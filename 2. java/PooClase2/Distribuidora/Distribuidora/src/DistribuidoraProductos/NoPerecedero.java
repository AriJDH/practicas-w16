package DistribuidoraProductos;

public class NoPerecedero extends Producto{

    public String tipo;

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

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public void calcular(int cantidadDeProductos) {
        super.calcular(cantidadDeProductos);
    }
}
