package Main;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        int reduccion = 1;

        switch(this.diasPorCaducar){
            case 1:
                reduccion = 4;
                break;
            case 2:
                reduccion = 3;
                break;
            case 3:
                reduccion = 2;
                break;
            default:
                break;
        }

        return this.precio * cantidadDeProductos / reduccion;
    }
}
