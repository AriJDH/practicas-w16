package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;

public class EstudianteTecnico extends Estudiante implements ISoporte{

    public EstudianteTecnico(String dni, String nombre, String apellido, int grado) {
        super(dni, nombre, apellido, grado);
    }

    @Override
    public void darSporte() {
        System.out.println("Soy un estudiante tecnico estoy en el grado "+getGrado() +" y apoyo dando soporte mi nombre es" + getNombre());
    }
}
