package Julio27.DistribuidoraDeProductos;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public Perecedero(String nombre, double precio,int diasPorCaducar) {
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        float precioRetorno = (float)super.calcular(cantidadDeProductos);
        switch (diasPorCaducar){
            case 1: precioRetorno = precioRetorno/4;
            break;
            case 2: precioRetorno = precioRetorno/3;
            break;
            case 3: precioRetorno = precioRetorno/2;
            break;
        }
        return precioRetorno;
    }
}
