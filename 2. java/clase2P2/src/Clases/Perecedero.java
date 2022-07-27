package Clases;

public class Perecedero extends Producto{
    int diasPorCaducar;

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
    public double calcular(int cantidadDeProductos){
        double precioBase = cantidadDeProductos*precio;
        int divisor;

        switch (diasPorCaducar){
            case 1:
                divisor = 4;
                break;

            case 2:
                divisor = 3;
                break;

            case 3:
                divisor = 2;
                break;

            default:
                divisor = 1;
                break;
        }

        return precioBase/divisor;

    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\tPrecio unitario: " + precio + "\tDias para caducar: " + diasPorCaducar;
    }

}
