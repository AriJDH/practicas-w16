package ejercicio3;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
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
    public Double calcular(Double cantidadDeProductos) {
        Double precioCalculado = super.calcular(cantidadDeProductos);
        Double precioACobrar;

        switch(diasPorCaducar){
            case 1:
                precioACobrar = precioCalculado - (this.getPrecio() * 4);
                break;
            case 2:
                precioACobrar = precioCalculado - (this.getPrecio() * 3);
                break;
            case 3:
                precioACobrar = precioCalculado - (this.getPrecio() * 5);
                break;
            default:
                precioACobrar = precioCalculado;
                break;
        }
        return precioACobrar;
    }
}
