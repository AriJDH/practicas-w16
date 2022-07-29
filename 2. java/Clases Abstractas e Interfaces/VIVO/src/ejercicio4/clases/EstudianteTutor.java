package ejercicio4.clases;

import ejercicio4.interfaces.Ensenar;

public class EstudianteTutor extends Estudiante implements Ensenar {
    private String materia;

    public EstudianteTutor(String nombre, int edad, String materia) {
        super(nombre, edad);
        this.materia = materia;
    }

    public EstudianteTutor() {}

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Tutor: \n" +
                "Nombre: " + super.getNombre() + " \n"+
                "Edad: " + super.getEdad() + "\n";
    }

    @Override
    public void ensenar(String tema) {
        System.out.println("El tutor " + super.getNombre() + " está enseñando de " + this.materia + " el tema " + tema);
    }
}
