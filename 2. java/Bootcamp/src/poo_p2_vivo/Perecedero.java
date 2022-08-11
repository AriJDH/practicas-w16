package poo_p2_vivo;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if (diasPorCaducar == 1) return super.calcular(cantidadDeProductos) / 4;
        if (diasPorCaducar == 2) return super.calcular(cantidadDeProductos) / 3;
        if (diasPorCaducar == 3) return super.calcular(cantidadDeProductos) / 2;
        return super.calcular(cantidadDeProductos);
    }

    @Override
    public String toString() {
        return super.toString()+
                "\t-Días para caducar: " + diasPorCaducar +
                '\n';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
