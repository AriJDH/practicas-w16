/*
 * Crear la clase Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int, al igual que para el producto, 
 * definir setters, getters, constructor que reciba todos los atributos por parámetro y el método toString(). 
 * Esta clase debe heredar de Producto y sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase Producto 
 * (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir el precio según los diasPorCaducar:
 * Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
 * Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
 * Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.
 */

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
