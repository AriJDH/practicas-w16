package DistribuidoraProductos;

public class Perecedero extends Producto {

    public int diasPorCaducar;

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
                '}';
    }

    @Override
    public void calcular(int cantidadDeProductos) {
        if (diasPorCaducar == 1){
            precio = (precio /4)*cantidadDeProductos;
        }else if(diasPorCaducar == 2){
            precio = (precio /3)*cantidadDeProductos;
        }else if(diasPorCaducar == 3){
            precio = (precio /2)*cantidadDeProductos;
        }
    }
}
