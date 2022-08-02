package practica_2;

public class Perecedero extends Producto {
    int diasPorCalcular;

    public Perecedero(String nombre, double precio, int diasPorCalcular) {
        super(nombre, precio);
        this.diasPorCalcular = diasPorCalcular;
    }


    public int getDiasPorCalcular() {
        return diasPorCalcular;
    }

    public void setDiasPorCalcular(int diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
    }

    @Override
    public String toString() {
        return "Nombre : " + nombre + "\n" +
                "Precio : " + precio + "\n" +
                "dias por calcular : " + diasPorCalcular + "\n";
    }

    @Override
    double calcular(int cantidadProductos) {
        double precio = super.calcular(cantidadProductos);

        switch (diasPorCalcular){
            case 1:{
                double valor = precio/4;
                precio -= valor;
                break;
            }
            case 2:{
                double valor = precio/3;
                precio -= valor;
                break;
            }
            case 3 :{
                double valor = precio/2;
                precio -= valor;
                break;
            }
            default:
                break;
        }
        return  precio;
    }
}
