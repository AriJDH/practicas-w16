package Ejercicios3;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int dias) {
        super(nombre, precio);
        this.diasPorCaducar = dias;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){

       switch (cantidadDeProductos){
           case 1:
               return (this.precio * cantidadDeProductos) / 4;
               case 2:
                  return (this.precio * cantidadDeProductos) / 3;
                  case 3:
                    return (this.precio * cantidadDeProductos) / 2;
       }
         return 0;
    }

}
