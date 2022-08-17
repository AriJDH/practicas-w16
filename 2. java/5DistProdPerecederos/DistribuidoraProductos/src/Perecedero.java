public class Perecedero extends Producto  {
    int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
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
    public double calcular(int cantidadDeProductos) {

        double precio = super.calcular(cantidadDeProductos);
        System.out.println("precio del Producto " + precio);
        double newPrecio;

        if(this.diasPorCaducar == 1){
            newPrecio = precio - (precio*0.4);
        }else if(this.diasPorCaducar == 2){
            newPrecio = precio - (precio*0.3);
        }else if(this.diasPorCaducar == 3){
            newPrecio = precio - (precio*0.5);
        }else{
            newPrecio = precio;
        }
        return newPrecio;
    }
}
