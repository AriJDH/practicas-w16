public class Perecederos  extends Producto{


    int diasPorCaducar;

    public Perecederos(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar=diasPorCaducar;
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setPrecio(double precio) {
        super.setPrecio(precio);
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Nombre:"+getNombre()+"\nPrecio:"+getPrecio()+"Dias por caducar:"+this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double valor_total=super.calcular(cantidadDeProductos);

        switch (diasPorCaducar){

            case 1:{
                    return (valor_total-(valor_total/4));


            }

            case 2:{
                return valor_total-(valor_total/3);


            }
            case 3: {
                return valor_total-(valor_total/2);

            }
        }

        return valor_total;
    }


}
