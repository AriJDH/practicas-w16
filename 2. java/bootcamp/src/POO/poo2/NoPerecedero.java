package POO.poo2;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo){
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.getNombre() + "\nPrecio: " + this.getPrecio() +
                "\nTipo = " + this.tipo ;
    }
}
