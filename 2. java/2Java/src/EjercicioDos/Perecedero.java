package EjercicioDos;

public  class Perecedero extends  Producto{
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
    public String toString()
    {
        return super.toString()+" Días por Caducar: "+this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad)
    {
        double total =   super.calcular(cantidad);
        if(this.diasPorCaducar == 1)
            total = total/4;
        else if(this.diasPorCaducar == 2)
            total = total/3;
        else if(this.diasPorCaducar == 3)
            total = total/2;

        return total;
    }
}
