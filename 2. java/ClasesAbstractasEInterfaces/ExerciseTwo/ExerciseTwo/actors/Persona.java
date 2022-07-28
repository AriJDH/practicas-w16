package ExerciseTwo.actors;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private List<String> skills;

    public Persona(String nombre, String apellido, List<String> skills) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.skills = skills;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", skills=" + skills + '}';
    }
}
