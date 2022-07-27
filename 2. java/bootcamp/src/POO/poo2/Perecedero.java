package POO.poo2;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, int precio, int diasPorCaducar){
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
        return "Nombre: " + this.getNombre() + "\nPrecio: " + this.getPrecio() +
                "\nDías por caducar = " + this.diasPorCaducar ;
    }

    @Override
    public double calcular(int cantProductos){
        double precio = this.precio * cantProductos ;

        if (this.diasPorCaducar == 1)
            return (precio / 4);
        else if (this.diasPorCaducar == 2)
            return (precio / 3);
        else if (this.diasPorCaducar == 3)
            return (precio / 2);
        else
            return precio;
    }
}
