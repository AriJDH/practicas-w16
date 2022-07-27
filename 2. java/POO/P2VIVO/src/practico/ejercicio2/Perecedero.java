package practico.ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double calcular(int cantidadProductos) {
        switch (diasPorCaducar){
            case 1:
                return super.calcular(cantidadProductos) / 4;
            case 2:
                return super.calcular(cantidadProductos) / 3;
            case 3:
                return super.calcular(cantidadProductos) / 2;
            default:
                return super.calcular(cantidadProductos);
        }
    }
}
