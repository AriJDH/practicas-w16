package PilaresPOO;

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidad){
        double resultado = 0;

        if(this.diasPorCaducar ==1) resultado = cantidad*this.getPrecio()/4;
        if(this.diasPorCaducar ==2) resultado = cantidad*this.getPrecio()/3;
        if(this.diasPorCaducar ==3) resultado = cantidad*this.getPrecio()/2;
        if(this.diasPorCaducar >3) resultado = cantidad*this.getPrecio();
        return resultado;

    }

}
