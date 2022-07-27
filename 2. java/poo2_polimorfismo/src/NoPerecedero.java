public class NoPerecedero extends Producto {

    String tipo;


    public NoPerecedero(String nombre, double precio,String tipo) {
        super(nombre, precio);
        this.tipo=tipo;
    }

    @Override
    public void setPrecio(double precio) {
        super.setPrecio(precio);
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString()+"\nTipo:"+this.tipo;
    }
}
