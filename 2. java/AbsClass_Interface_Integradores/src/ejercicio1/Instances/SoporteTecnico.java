package ejercicio1.Instances;

import ejercicio1.AbstractClasses.Persona;
import ejercicio1.Interfaces.Acciones;

public class SoporteTecnico extends Persona implements Acciones {

    public SoporteTecnico(String dni, String nombre, String apellido, int edad) {
        super(dni, nombre, apellido, edad);
    }

    @Override
    public String ejecutarAccion() {
        return "asiste a un miembro de la organización";
    }
}
