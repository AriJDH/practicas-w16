package Ejercicios4;

public class PersonalSoporteTecnico extends Persona{

        public PersonalSoporteTecnico(String nombre) {
            super(nombre);
        }

        @Override
        public void decirCargo() {
            System.out.println("Personal de soporte");
        }
}
