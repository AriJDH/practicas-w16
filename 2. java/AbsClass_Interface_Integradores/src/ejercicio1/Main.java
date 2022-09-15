package ejercicio1;

import ejercicio1.Instances.Estudiante;
import ejercicio1.Instances.EstudianteTecnico;
import ejercicio1.Instances.Tutor;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("1234567-8", "Patricio", "Donald", 23);
        Tutor tutor = new Tutor("2345678-9", "Max", "Payne", 35);
        EstudianteTecnico tecnico = new EstudianteTecnico("3456789-0", "Antonio", "Stark", 25);

        System.out.println("El tutor " + tutor.ejecutarAccion());
        System.out.println("El estudiante técnico " + tecnico.ejecutarAccion());
    }
}
