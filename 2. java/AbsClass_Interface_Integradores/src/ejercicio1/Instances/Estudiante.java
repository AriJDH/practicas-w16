package ejercicio1.Instances;

import ejercicio1.AbstractClasses.Persona;
import ejercicio1.Interfaces.Acciones;

public class Estudiante extends Persona implements Acciones {

    public Estudiante(String dni, String nombre, String apellido, int edad) {
        super(dni, nombre, apellido, edad);
    }

    @Override
    public String ejecutarAccion() {
        return "se pone a estudiar";
    }
}
