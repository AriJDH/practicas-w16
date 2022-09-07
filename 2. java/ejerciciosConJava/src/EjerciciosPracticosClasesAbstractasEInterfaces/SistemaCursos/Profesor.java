package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;


public class Profesor extends Persona implements ICurso{

    private String curso;

    public Profesor(String dni, String nombre, String apellido, String curso) {
        super(dni, nombre, apellido);
        this.curso = curso;
    }

    @Override
    public void impartirCurso() {
        System.out.println("El profesor "+super.getNombre()+" imparte el curso "+this.curso);
    }
}
