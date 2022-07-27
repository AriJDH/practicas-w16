package poo.ejercicioDistribuidora;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return this.diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        double precioTotal = getPrecio() * cantidadDeProductos;

        switch (this.diasPorCaducar) {
            case 1:
                precioTotal = (precioTotal / 4);
                break;
            case 2:
                precioTotal = (precioTotal / 3);
                break;
            case 3:
                precioTotal = (precioTotal / 2);
                break;
        }
        return precioTotal;

    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                "} " + super.toString();
    }
}
