package Ejercicios4;

public class EstudianteTecnico extends Estudiante{

        public EstudianteTecnico(String nombre) {
            super(nombre);
        }

        @Override
        public void decirCargo() {
            System.out.println("Estudiante técnico");
        }

}
