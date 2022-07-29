package ejercicio4.clases;

import ejercicio4.interfaces.SoporteTecnico;

public class PersonalSoporteTecnico extends Personal implements SoporteTecnico {

    public PersonalSoporteTecnico(String nombre, int edad) {
        super(nombre, edad);
    }

    public PersonalSoporteTecnico() {}

    @Override
    public String toString() {
        return "Personal de Soporte Tecnico: \n" +
                "Nombre: " + super.getNombre() + " \n"+
                "Edad: " + super.getEdad() + "\n";
    }

    @Override
    public void darSoporteTecnico(String algo) {
        System.out.println(super.getNombre() + " del personal de Soporte Tecnico está reparando " + algo);
    }
}
