package ejercicio5.clases;

import java.util.List;

public class Participante {
    private String nombre;
    private NaveSimple nave = null;
    private Flota flota = null;

    public Participante(String nombre, Flota flota) {
        this.nombre = nombre;
        this.flota = flota;
    }

    public Participante(String nombre, NaveSimple nave) {
        this.nombre = nombre;
        this.nave = nave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NaveSimple getNave() {
        return nave;
    }

    public void setNave(NaveSimple nave) {
        this.nave = nave;
    }

    public Flota getFlota() {
        return flota;
    }

    public void setFlota(Flota flota) {
        this.flota = flota;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", nave=" + nave +
                ", flota=" + flota +
                '}';
    }
}
