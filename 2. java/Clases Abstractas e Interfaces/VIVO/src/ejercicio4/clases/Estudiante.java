package ejercicio4.clases;

public class Estudiante extends Persona{
    public Estudiante(String nombre, int edad) {
        super(nombre, edad);
    }

    public Estudiante() {
    }

    @Override
    public String toString() {
        return "Estudiante: \n" +
                "Nombre: " + super.getNombre() + " \n" +
                "Edad: " + super.getEdad() + "\n";
    }

    public void estudiar(String tema){
        System.out.println(super.getNombre() + " esta estudiando " + tema);
    }
}
