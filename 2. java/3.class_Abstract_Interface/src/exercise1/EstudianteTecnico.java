package exercise1;

public class EstudianteTecnico extends Estudiante implements IVoluntariable{
    @Override
    public void colaborarSoporteTecnico() {
        System.out.println("Estudiantes tecnicos colaboran en soporte tecnico");
    }
}
