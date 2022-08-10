package excepciones;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double ret = getPrecio() * cantidadDeProductos;
        switch (diasPorCaducar) {
            case 1:
                ret = ret / 4;
                break;
            case 2:
                ret = ret / 3;
                break;
            case 3:
                ret = ret / 2;
                break;
        }
        return ret;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

}
