
package PooTwoExercises;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    /*
     * CONSTRUCTOR
     */

    public Perecedero(String nombre, int precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    /*
     * GETTERS
     */

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    /*
     * SETTERS
     */

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        String producto = "Perecedero { " + "\n" +
                "Nombre: " + nombre + "\n" +
                "Precio: " + precio + "\n" +
                "Dias por caducar: " + diasPorCaducar + "\n" +
                "}";

        return producto;
    }

    @Override
    double calcular(int cantidadDeProductos) {
        double precioBase = super.calcular(cantidadDeProductos);
        double precioFinal = precioBase;

        if (diasPorCaducar == 1)
            precioFinal *= 0.25;
        else if (diasPorCaducar == 2)
            precioFinal /= 3;
        else if (diasPorCaducar == 3)
            precioFinal *= 0.5;

        return precioFinal;
    }

}
