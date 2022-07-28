package Excepciones_POO;

public class NoPerecedero extends Producto {

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

    @Override
    public String toString() {
        return super.toString() + " Excepciones_Herencia_Encapsulamiento_Polimorfismo.NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

}
