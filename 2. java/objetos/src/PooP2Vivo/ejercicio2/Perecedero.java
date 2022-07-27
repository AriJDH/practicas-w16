package PooP2Vivo.ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + "y le quedan " + diasPorCaducar + " para su vencimineto";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);

        if (this.diasPorCaducar == 1)
            return precio / 4;
        else if (this.diasPorCaducar == 2)
            return precio / 3;
        else if (this.diasPorCaducar == 3)
            return precio / 2;
        else
            return precio;
    }
}
