package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;

public class Tutor extends Estudiante implements ICurso{


    public Tutor(String dni, String nombre, String apellido, int grado, String curso) {
        super(dni, nombre, apellido, grado, curso);
    }

    @Override
    public void impartirCurso() {
        System.out.println("Soy un tutor y voy a impartir el curso de " + getCurso());
    }
}
