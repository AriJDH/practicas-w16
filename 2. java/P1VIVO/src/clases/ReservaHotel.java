package clases;

import interfaces.Compra;

public class ReservaHotel extends Compra {
    private String nombre;

    public ReservaHotel(double precio, String nombre) {
        super(precio);
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
