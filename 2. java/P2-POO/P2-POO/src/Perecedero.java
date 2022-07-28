
public class Perecedero extends Producto{
    private static int diasPorCaducar;

    public static int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public static void setDiasPorCaducar(int diasPorCaducar) {
        Perecedero.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;

    }
    @Override
    public double calcular(int cantidadDeProductos){
        double total =  super.calcular(cantidadDeProductos) ;
        if (diasPorCaducar == 1){
            return total/4;
        }
        if (diasPorCaducar == 2 ) {
            return total/3;
        }
        if (diasPorCaducar == 3){
            return total/2;
        }
        return total;
    }
    @Override
    public String toString() {
        return "{Nombre del producto=" + getNombre() + " " + " precio: " + getPrecio() + "dias por caducar"+ diasPorCaducar + "}";
    }
}
