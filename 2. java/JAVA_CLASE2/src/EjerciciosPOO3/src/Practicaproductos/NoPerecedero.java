package Practicaproductos;

public class NoPerecedero extends Producto{

    private String tipo;
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getTipo() { return tipo;}

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " y es de tipo " + this.tipo;
    }
}
