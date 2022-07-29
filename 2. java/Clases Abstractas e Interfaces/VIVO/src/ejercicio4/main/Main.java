package ejercicio4.main;

import ejercicio4.clases.*;

public class Main {
    public static void main(String[] args) {
        EstudianteTecnico estudianteTecnico = new EstudianteTecnico();
        estudianteTecnico.setNombre("Jorge Pérez");
        estudianteTecnico.setEdad(23);
        estudianteTecnico.darSoporteTecnico("computadoras");
        estudianteTecnico.estudiar("matematicas");

        EstudianteTutor estudianteTutor = new EstudianteTutor();
        estudianteTutor.setMateria("Programación 1");
        estudianteTutor.setNombre("Alberto Díaz");
        estudianteTutor.setEdad(33);
        estudianteTutor.ensenar("Clases Abstractas y Interfaces");
        estudianteTutor.estudiar("Algebra");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Marcos Rodriguez");
        estudiante.setEdad(24);
        estudiante.estudiar("Geometria");

        Profesor profesor = new Profesor();
        profesor.setNombre("Carlos Martínez");
        profesor.setEdad(44);
        profesor.ensenar("Matematicas 2");

        PersonalMantenimiento personalMantenimiento = new PersonalMantenimiento();
        personalMantenimiento.setNombre("Sergio Acosta");
        personalMantenimiento.setEdad(28);
        personalMantenimiento.darMantenimiento("computadoras");

        PersonalSoporteTecnico personalSoporteTecnico = new PersonalSoporteTecnico();
        personalSoporteTecnico.setNombre("Hector Bombilla");
        personalSoporteTecnico.setEdad(33);
        personalSoporteTecnico.darSoporteTecnico("notebooks");
    }
}
