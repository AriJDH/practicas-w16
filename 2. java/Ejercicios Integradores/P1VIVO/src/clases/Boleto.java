package clases;

import interfaces.Compra;

public class Boleto extends Compra {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boleto(double precio, String tipo) {
        super(precio);
        this.tipo = tipo;
    }

}
