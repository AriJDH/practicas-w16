package practicaException2;

public class Perecedero extends Producto{
    private int diasPorCaducar;


    public Perecedero(String nombre, double precio ) {
        super(nombre, precio);
    }

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
    public double calcular(int n) {
        int dividir = 0;
        if (this.diasPorCaducar == 1){
            dividir = 4;
        } else if (this.diasPorCaducar == 2) {
            dividir = 3;
        } else if (this.diasPorCaducar == 3){
            dividir = 2;
        }
        return super.calcular(n)/dividir;
    }

    @Override
    public String toString() {
        return "Perecedero{" + super.toString() +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
