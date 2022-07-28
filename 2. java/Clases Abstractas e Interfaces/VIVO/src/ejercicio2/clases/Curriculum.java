package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Imprimible {
    private Persona persona;
    private List<String> habilidades;

    public Curriculum() {
    }

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("\n\nImprimiendo Curriculum...\n");
        System.out.print(this.persona.toString() + "------------\n");
        System.out.println("Habilidades: ");
        for (String habilidad : this.habilidades) {
            System.out.println(habilidad);
        }
    }
}
