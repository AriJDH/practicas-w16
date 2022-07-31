package modelo;

import java.util.List;

public class Hotel implements Reserva{
    private int numeroDias;
    private final double precioDia;
    private String nombre;
    private String tipoHabitacion;

    public Hotel(int numeroDias, double precioDia, String nombre, String tipoHabitacion) {
        this.numeroDias = numeroDias;
        this.precioDia = precioDia;
        this.nombre = nombre;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "numeroDias=" + numeroDias +
                ", precioDia=" + precioDia +
                ", nombre='" + nombre + '\'' +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                '}';
    }

    @Override
    public double darPrecio() {
        return this.numeroDias*this.precioDia;
    }

    @Override
    public String tipo() {
        return "hotel";
    }


}
