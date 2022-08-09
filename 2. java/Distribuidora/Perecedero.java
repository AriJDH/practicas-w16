package Distribuidora;

public class Perecedero extends Producto {
    int diasPorCaducar;

    Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Distribuidora.Perecedero{" + "nombre='" + this.getNombre() + '\'' + ", precio=" + this.getPrecio() + '\'' + "diasPorCaducar=" + diasPorCaducar + '}';
    }

    double calcular(int cantidad) {
        double total = this.getPrecio() * cantidad;
        if (this.diasPorCaducar == 3) {
            return total / 2;
        }
        if (this.diasPorCaducar == 2) {
            return total / 3;
        }
        if (this.diasPorCaducar == 1) {
            return total / 4;
        }
        return total;
    }
}
