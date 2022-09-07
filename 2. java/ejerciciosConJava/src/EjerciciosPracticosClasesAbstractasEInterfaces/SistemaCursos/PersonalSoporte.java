package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;

public class PersonalSoporte extends Persona implements ISoporte{

    public PersonalSoporte(String dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    @Override
    public void darSporte() {
        System.out.println(getNombre()+ " esta dando soporte");
    }
}
