package ejercicio1.Instances;

import ejercicio1.AbstractClasses.Persona;
import ejercicio1.Interfaces.Acciones;

public class Personal extends Persona implements Acciones {

    public Personal(String dni, String nombre, String apellido, int edad) {
        super(dni, nombre, apellido, edad);
    }

    @Override
    public String ejecutarAccion() {
        return "realiza algún trabajo";
    }
}
