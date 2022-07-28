package Herencia.Ejercico2;

public class Peredecedero extends Producto{

    private int diasPorCaducar;

    public Peredecedero(String nombre, double precio, int diasPorCaducar) {
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
        return "Peredecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
  public double caluclar(int cantidadDeProductos){
      double precioProducto =this.precio*cantidadDeProductos;

      if(diasPorCaducar==1){
          precioProducto=precioProducto/4;
      }
       else if(diasPorCaducar==2){
            precioProducto=precioProducto/3;
        }
       else  if(diasPorCaducar==3){
          precioProducto=precioProducto/2;
      }

       return precioProducto;
  }
}
