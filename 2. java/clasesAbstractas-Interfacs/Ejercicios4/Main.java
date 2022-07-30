package Ejercicios4;

public class Main {
    public static void main(String[] args) {

        Persona estudiante = new Estudiante("ruben");
        Persona profesor = new Profesores("juan");
        Persona personal = new PersonalMantenimiento("pedro");
        Persona tutor = new Tutores("jose");
        Persona estudianteTecnico = new EstudianteTecnico("juan");
        Persona personalSoporte = new PersonalSoporteTecnico("jose");
        Persona miembroPersonal = new MiembroPersonal("jose");

        estudiante.decirCargo();
        profesor.decirCargo();
        personal.decirCargo();
        tutor.decirCargo();
        estudianteTecnico.decirCargo();
        personalSoporte.decirCargo();
        miembroPersonal.decirCargo();

    }
}
