package SeriesNumericas;

public class Estudiante extends Persona implements IEstudiante {
    public Estudiante(Integer edad, String nombre) {
        super(edad, nombre);
    }

    @Override
    public void estudia() {
        System.out.println("Estudiando");
    }
}
