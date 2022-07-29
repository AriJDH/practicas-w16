package POOP2VIVO.Ejercicio2;

public class NoPerecedero extends Producto {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        //se llama a el toString de la clase padre y se le agrega lo demas
        return super.toString() + " Tipo : " + tipo;
    }
}
