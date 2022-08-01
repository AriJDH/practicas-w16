package poo.ejercicioImprimir;

public class Curriculum implements Imprimible {

    private Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum" + "\n" + persona);
    }
}
