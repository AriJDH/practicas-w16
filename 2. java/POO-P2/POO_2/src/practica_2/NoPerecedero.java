package practica_2;

public class NoPerecedero extends Producto {
    String Tipo;

    public NoPerecedero(String nombre, double precio,String tipo) {
        super(nombre, precio);
        Tipo = tipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "";

    }


}
