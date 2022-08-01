package Ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

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
    public String toString(){
        return "Nombre: " + nombre + "Precio: " + precio;
    }

    public double calcular(int cantidadDeProductos){
       double reduccionPrecio = super.calcular(cantidadDeProductos);
       switch (diasPorCaducar){
           case 1: return reduccionPrecio/4;
           case 2: return reduccionPrecio/3;
           case 3: return reduccionPrecio/2;
           default: return reduccionPrecio;
       }
    }
}
