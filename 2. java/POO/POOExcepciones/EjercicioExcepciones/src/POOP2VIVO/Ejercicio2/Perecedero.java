package POOP2VIVO.Ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        //Se llama al metodo de la clase padre
        double resultado = super.calcular(cantidadDeProductos);
        switch (diasPorCaducar) {
            case 1:
                return resultado / 4;
            case 2:
                return resultado / 3;
            case 3:
                return resultado / 2;
            case 4:
                return resultado;

        }
        return cantidadDeProductos * getPrecio();
    }

    @Override
    public String toString() {
        //se llama a el toString de la clase padre y se le agrega lo demas
        return super.toString() + " Días por caducar: " + diasPorCaducar;
    }


}
