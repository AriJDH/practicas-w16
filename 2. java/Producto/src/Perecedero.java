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
    public String toString(){
        return "Dias por caducar: "+this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double valor =   super.calcular(cantidadDeProductos);

        if(this.diasPorCaducar==1){
            valor = valor/4;
        }
        else if(this.diasPorCaducar ==2){
            valor = valor/3;
        }
        else if (this.diasPorCaducar == 3){
            valor = valor/2;
        }
        return valor;
    }
}
