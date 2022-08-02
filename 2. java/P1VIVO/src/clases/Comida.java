package clases;

import interfaces.Compra;

public class Comida extends Compra {
    private String tipo;

    @Override
    public String toString() {
        return "Comida{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comida(double precio, String tipo) {
        super(precio);
        this.tipo = tipo;
    }

}
