package Ejercicios4;

public class PersonalMantenimiento extends Persona{

    public PersonalMantenimiento(String nombre) {
        super(nombre);
    }

    @Override
    public void decirCargo() {
        System.out.println("Miembro del personal");
    }
}
