package practica_2;

public class Perecedero extends Producto {
    int diasPorCalcular;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }


    public int getDiasPorCalcular() {
        return diasPorCalcular;
    }

    public void setDiasPorCalcular(int diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
