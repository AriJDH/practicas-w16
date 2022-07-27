public class Perecedero extends Producto{
    int diasPorCaducar;

    // Constructores
    public Perecedero(){

    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    // Getters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    // Setters
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //Metodos
    @Override
    public String toString() {
        return "Perecedero{" + "nombre=" + getNombre() +
                "precio= " + getPrecio() +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioNuevo;
        switch(this.diasPorCaducar){
            case 1:
                precioNuevo = getPrecio()/4;
                break;
            case 2:
                precioNuevo = getPrecio()/3;
                break;
            case 3:
                precioNuevo = getPrecio()/2;
                break;
            default:
                precioNuevo = getPrecio();
        }
        return cantidadDeProductos*precioNuevo;
    }
}
