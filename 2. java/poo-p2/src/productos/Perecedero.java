package productos;

public class Perecedero extends Producto {
    private int diasPorCaducar;


    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                '}';
    }

    @Override
    public double calcular(int cantidad) {
        double precio = super.calcular(cantidad);
        if(diasPorCaducar <=0)
            precio = 0;
        else if(diasPorCaducar == 1)
            precio /= 4;
        else if (diasPorCaducar == 2)
            precio /= 3;
        else if (diasPorCaducar == 3)
            precio /= 2;
        return precio;
    }
}
