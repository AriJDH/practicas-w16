package Ejercicios4;

public class Estudiante extends Persona{

    public Estudiante(String nombre) {
        super(nombre);
    }

    @Override
    public void decirCargo() {
        System.out.println("Estudiante");
    }

}
