package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;

public class Estudiante extends Persona{

    private int grado;
    private String curso;

    public Estudiante(String dni, String nombre, String apellido, int grado,String curso) {
        super(dni, nombre, apellido);
        this.grado = grado;
        this.curso= curso;
    }

    public Estudiante(String dni, String nombre, String apellido, int grado) {
        super(dni, nombre, apellido);
        this.grado = grado;

    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
