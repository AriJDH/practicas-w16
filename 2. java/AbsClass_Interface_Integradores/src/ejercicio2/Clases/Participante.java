package ejercicio2.Clases;

import ejercicio2.Interface.Nave;

import java.util.List;

public class Participante {

    private String nombre;
    private NaveSimple naveSimple;
    private FlotaDeNaves flotaDeNaves;
    private int puntuacion;

    public Participante(String nombre, NaveSimple naveSimple, int puntuacion) {
        this.nombre = nombre;
        this.naveSimple = naveSimple;
        this.puntuacion = puntuacion;
    }

    public Participante(String nombre, FlotaDeNaves flotaDeNaves, int puntuacion) {
        this.nombre = nombre;
        this.flotaDeNaves = flotaDeNaves;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NaveSimple getNaveSimple() {
        return naveSimple;
    }

    public void setNaveSimple(NaveSimple naveSimple) {
        this.naveSimple = naveSimple;
    }

    public FlotaDeNaves getFlotaDeNaves() {
        return flotaDeNaves;
    }

    public void setFlotaDeNaves(FlotaDeNaves flotaDeNaves) {
        this.flotaDeNaves = flotaDeNaves;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
