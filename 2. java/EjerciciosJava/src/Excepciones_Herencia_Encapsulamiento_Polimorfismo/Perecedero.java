package Excepciones_Herencia_Encapsulamiento_Polimorfismo;

public class Perecedero extends Producto {

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
    public String toString() {
        return super.toString() + " Excepciones_Herencia_Encapsulamiento_Polimorfismo.Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        if(this.diasPorCaducar == 1){
            return super.calcular(cantidadDeProductos) / 4;
        } else if(this.diasPorCaducar == 2){
            return super.calcular(cantidadDeProductos) / 3;
        } else if(this.diasPorCaducar == 3){
            return super.calcular(cantidadDeProductos) / 2;
        } else {
            return super.calcular(cantidadDeProductos);
        }

    }
}
