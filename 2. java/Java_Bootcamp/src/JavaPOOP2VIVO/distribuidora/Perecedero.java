package JavaPOOP2VIVO.distribuidora;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calcular(int cantidadDeProductos) {
        double calculo = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) calculo = -4;
        if (diasPorCaducar == 2) calculo = -3;
        if (diasPorCaducar == 3) calculo = calculo / 2;
        return calculo;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
