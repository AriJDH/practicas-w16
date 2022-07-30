package Ejercicios5;

import java.util.List;

public class Participante {

    private Nave nave;
    private String nombre;
    private FlotaNaves flotaNaves;

    public Participante(Nave nave, String nombre) {
        this.nave = nave;
        this.nombre = nombre;
    }

    public Participante(FlotaNaves flotanaves, String nombre) {
        this.flotaNaves = flotanaves;
        this.nombre = nombre;
    }

    public Nave getNave() {
        return nave;
    }

    public FlotaNaves getFlotaNaves() {
        return flotaNaves;
    }

    public String getNombre() {
        return nombre;
    }
}
