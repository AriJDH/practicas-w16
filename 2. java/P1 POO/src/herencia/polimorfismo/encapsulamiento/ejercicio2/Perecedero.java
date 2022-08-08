package herencia.polimorfismo.encapsulamiento.ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        setNombre(nombre);
        setPrecio(precio);
        setDiasPorCaducar(diasPorCaducar);
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
                "} " + super.toString();
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = getPrecio()*cantidadDeProductos;
        switch (getDiasPorCaducar()){
            case 1: return precioFinal/4;
            case 2: return precioFinal/3;
            case 3: return precioFinal/2;
            default: return precioFinal;
        }
    }
}
