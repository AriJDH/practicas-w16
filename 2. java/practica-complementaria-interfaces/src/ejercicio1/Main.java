package ejercicio1;

public class Main {

    public static void main(String[] args) {
        // Clase abstracta Persona - clase concreta Estudiante
        Persona estudiante = new Estudiante(123);

        // Superclase Estudiante - clase concreta Tutor, interface Capacitador
        Tutor tutor = new Tutor(1234);
        tutor.enseñar();

        //Superclase Estudiante - clase concreta EstudianteTecnico, interface Tecnico
        EstudianteTecnico estudianteTecnico = new EstudianteTecnico(12345);
        estudianteTecnico.reparar();
    }

}
