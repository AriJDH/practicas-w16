package Ejercicios4;

public class Tutores extends Estudiante{

    public Tutores(String nombre) {
        super(nombre);
    }

    @Override
    public void decirCargo() {
        System.out.println("Tutor");
    }

}
