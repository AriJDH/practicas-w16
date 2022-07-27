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
                "nombre='" + this.getNombre() + '\'' +
                ", precio=" + this.getPrecio() +
                " diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double res = 0;
        if (diasPorCaducar ==1)
            res = this.getPrecio()/4;
        else if (diasPorCaducar==2)
            res= this.getPrecio()/3;
        else if (diasPorCaducar==3)
            res =this.getPrecio()/2;
        else
            res = this.getPrecio();
        return res *cantidadDeProductos;
    }

}
