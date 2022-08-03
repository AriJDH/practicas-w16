package cl.morsecode.cl.entities.deportista;

public class Deporte {
    private String nombre;
    private int nivel;

    public String getNombre() {
        return nombre;
    }

    public Deporte() {
    }

    public Deporte(String nombre) {
        this.nombre = nombre;
    }

    public Deporte(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
