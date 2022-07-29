package practica.poo.p2.vivo;

public class Perecedero extends Producto {

    protected int diasPorCaducar;

    @Override
    public double calcular(int cantidadDeProductos) {
        if (this.diasPorCaducar == 1) {
            this.precio /= 4;
        } else if (this.diasPorCaducar == 2) {
            this.precio /= 3;
        } else if (this.diasPorCaducar == 3) {
            this.precio /= 2;
        }
        return super.calcular(cantidadDeProductos);
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
        int[] arr = {1, 2, 3};
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + this.nombre + '\'' +
                ", precio=" + this.precio +
                ", diasPorCaducar=" + this.diasPorCaducar +
                '}';
    }
}
