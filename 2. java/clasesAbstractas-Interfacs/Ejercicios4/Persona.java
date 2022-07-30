package Ejercicios4;

public abstract class Persona {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }

    public abstract void decirCargo();
}
