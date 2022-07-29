package ejercicio4.clases;

import ejercicio4.interfaces.Ensenar;

public class Profesor extends Persona implements Ensenar {
    @Override
    public String toString() {
        return "Profesor: \n" +
                "Nombre: " + super.getNombre() + " \n" +
                "Edad: " + super.getEdad() + "\n";
    }

    public Profesor(String nombre, int edad) {
        super(nombre, edad);
    }

    public Profesor() {
    }

    @Override
    public void ensenar(String tema) {
        System.out.println("El profesor " + super.getNombre() + " esta enseñando "+ tema);
    }
}
