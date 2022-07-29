package interfaces;

import java.time.LocalDate;

public abstract class Compra {
    private double precio;

    public Compra(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
