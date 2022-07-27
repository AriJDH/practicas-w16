public class Perecedero extends Producto {


    private int diasPorCaducar;


    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calculate(int cantidadProducto) {
        double total = cantidadProducto * getPrecio();

        try {
            if (diasPorCaducar == 1) {
                total = total / 4;
            }
            if (diasPorCaducar == 2) {
                total = total / 3;
            }
            if (diasPorCaducar == 3) {
                total = total / 3;
            }

        } catch (Exception e) {
            e.getMessage();

        }
        return total;

    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
