package Ejercicios4;

public class Profesores extends Persona{

    public Profesores(String nombre) {
        super(nombre);
    }

    @Override
    public void decirCargo() {
        System.out.println("Profesor");
    }
}
