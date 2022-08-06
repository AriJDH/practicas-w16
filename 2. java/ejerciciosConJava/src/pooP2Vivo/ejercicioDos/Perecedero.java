package pooP2Vivo.ejercicioDos;

public class Perecedero extends Producto{

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
    public double calcular(int cantidadDeProductos) {
        double precioFinal=0.0;
        double precioFinalDos=0.0;
        if(this.diasPorCaducar==1){
            //precioFinal=super.calcular(cantidadDeProductos);
            //precioFinalDos=precioFinal/4;
            //return precioFinalDos;
            return(super.calcular(cantidadDeProductos)/4);
        } else if (this.diasPorCaducar==2) {
            return(super.calcular(cantidadDeProductos)/3);
        } else if (this.diasPorCaducar==3) {
            return(super.calcular(cantidadDeProductos)/2);
        }else {
            return super.calcular(cantidadDeProductos);
        }
    }

    @Override
    public String toString() {

        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
