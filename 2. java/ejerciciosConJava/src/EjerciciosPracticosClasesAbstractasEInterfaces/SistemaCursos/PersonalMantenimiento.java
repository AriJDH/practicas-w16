package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;

public class PersonalMantenimiento extends Persona{

    public PersonalMantenimiento(String dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    @Override
    public String toString() {
        return super.toString() + "esta dando mantenimiento";
    }
}
