package ExerciseTwo.actors;

public class Curriculum extends Documento {
    
    private Persona persona;

    public Curriculum(Persona persona) {
        super("Curriculum");
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Curriculum{" + "persona=" + persona + '}';
    }
    
}
