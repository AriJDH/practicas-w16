package EjercicioClases;

public class Parecedero extends Producto {
    protected int diasPorCaducar;

    public Parecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Parecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double valorFinal;
        if (cantidadDeProductos<=1){
            valorFinal=getPrecio()/4;
        } else if (cantidadDeProductos<=2) {
            valorFinal=getPrecio()/3;
            return valorFinal*cantidadDeProductos;
        }
            valorFinal=getPrecio()/2;
            return valorFinal*cantidadDeProductos;
    }
}
