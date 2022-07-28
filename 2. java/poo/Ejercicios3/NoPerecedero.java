package Ejercicios3;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
