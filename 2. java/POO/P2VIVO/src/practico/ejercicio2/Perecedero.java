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
        return super.toString() + " Días por caducar: " + diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadProductos) {
        double resultado = super.calcular(cantidadProductos);
        switch (diasPorCaducar){
            case 1:
                return resultado / 4;
            case 2:
                return resultado / 3;
            case 3:
                return resultado / 2;
            default:
                return resultado;
        }
    }
}
