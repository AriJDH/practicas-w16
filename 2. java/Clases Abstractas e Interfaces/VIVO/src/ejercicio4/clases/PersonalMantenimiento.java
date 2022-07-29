package ejercicio4.clases;

import ejercicio4.interfaces.Mantenimiento;

public class PersonalMantenimiento extends Personal implements Mantenimiento {

    public PersonalMantenimiento(String nombre, int edad) {
        super(nombre, edad);
    }

    public PersonalMantenimiento() {}

    @Override
    public String toString() {
        return "Personal de mantenimiento: \n" +
                "Nombre: " + super.getNombre() + " \n"+
                "Edad: " + super.getEdad() + "\n";
    }

    @Override
    public void darMantenimiento(String algo) {
        System.out.println(super.getNombre() + " del personal de mantenimiento está reparando " + algo);
    }
}
