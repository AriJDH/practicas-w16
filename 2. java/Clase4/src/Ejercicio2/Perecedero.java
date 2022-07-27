package Ejercicio2;

public class Perecedero extends Producto{
    protected int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(){

    }

    public Perecedero(String nombre,double precio, int diasPorCaducar){
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double Calcular(int cantidadDeProductos) {
        int divididoEntre = 1;
        switch(diasPorCaducar){
            case 1: divididoEntre = 4;
                break;
            case 2: divididoEntre = 3;
                break;
            case 3: divididoEntre = 2;
                break;
        }

        return super.Calcular(cantidadDeProductos)/divididoEntre;
    }
}
