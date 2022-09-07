package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;

public class MiembroPersonal extends Persona{

    public MiembroPersonal(String dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    @Override
    public String toString() {
        return super.toString()+"es miembro del personal";
    }
}
