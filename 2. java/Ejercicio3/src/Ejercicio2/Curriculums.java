package Ejercicio2;

import java.util.List;

public class Curriculums implements Imprimible {

    private Persona persona;
    private List<Habilidades> habilidades;

    public Curriculums() {
    }

    public Curriculums(Persona persona, List<Habilidades> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public String imprimirDocumento() {
        return toString();
    }
}
