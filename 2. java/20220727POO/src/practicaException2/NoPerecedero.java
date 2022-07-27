package practicaException2;

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
    public double calcular(int n) {
        return super.calcular(n);
    }

    @Override
    public String toString() {
        return "NoPerecedero{" + super.toString() +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
