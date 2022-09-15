package ejercicio1.Instances;

import ejercicio1.AbstractClasses.Persona;
import ejercicio1.Interfaces.Acciones;

public class EstudianteTecnico extends Persona implements Acciones {

    public EstudianteTecnico(String dni, String nombre, String apellido, int edad) {
        super(dni, nombre, apellido, edad);
    }

    @Override
    public String ejecutarAccion() {
        return "colabora con el soporte técnico";
    }
}
