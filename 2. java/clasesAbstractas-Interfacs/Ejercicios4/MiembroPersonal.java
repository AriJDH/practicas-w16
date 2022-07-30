package Ejercicios4;

public class MiembroPersonal extends Persona{

    public MiembroPersonal(String nombre) {
        super(nombre);
    }

    @Override
    public void decirCargo() {
        System.out.println("Miembro del personal");
    }
}
