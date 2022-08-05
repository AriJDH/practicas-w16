import naves.Nave;

import java.util.List;

public class Participante {
    private String nombre;
    private Nave nave;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", nave=" + nave +
                '}';
    }

    public Participante(String nombre, Nave nave) {
        this.nombre = nombre;
        this.nave = nave;
    }
}
