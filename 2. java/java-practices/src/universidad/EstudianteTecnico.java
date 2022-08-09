package universidad;

public class EstudianteTecnico extends Estudiante implements ColaboradorTecnico {
    @Override
    public void colaborar() {
        System.out.println("ESTUDIANTE TÉCNICO: colaborando con el Soporte Técnico.");
    }
}
