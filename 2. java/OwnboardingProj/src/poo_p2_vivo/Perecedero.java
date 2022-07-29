package poo_p2_vivo;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero: " + "diasPorCaducar=" + diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double monto = this.getPrecio() * cantidadDeProductos;

        if (this.diasPorCaducar == 1) {
            return monto/4;
        } else if (this.diasPorCaducar == 2) {
            return monto/3;
        } else if (this.diasPorCaducar == 3) {
            return monto/2;
        } else {
            return monto;
        }
    }
}
