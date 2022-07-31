package EjercicioProducto;

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


    public double calcular(int cantidadDeproductos, int diasPorCaducar){
        double resultado = this.getPrecio() * cantidadDeproductos;
        if(diasPorCaducar == 1){
            resultado = resultado / 4;
        } else if (diasPorCaducar == 2) {
            resultado = resultado / 3;
        }else{
            resultado = resultado / 2;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
