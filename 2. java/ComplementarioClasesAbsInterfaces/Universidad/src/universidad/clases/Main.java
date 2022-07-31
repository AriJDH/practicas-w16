package universidad.clases;

public class Main {

    public static void main(String[] args){

        MiembrosPersonal miembros = new MiembrosPersonal();
        Estudiantes estudiantes = new EstudiantesTecnicos();
        Profesores profesores = new Profesores();
        PersonalMantenimiento mantenimiento = new PersonalMantenimiento();
        Tutores tutores = new Tutores();
        PersonalTecnico tecnico = new PersonalTecnico();
        EstudiantesTecnicos estudiantes_tecnicos = new EstudiantesTecnicos();


        miembros.cargo();
        estudiantes.cargo();

        profesores.cargo();
        profesores.educar();

        mantenimiento.cargo();

        tutores.cargo();
        tutores.educar();

        tecnico.cargo();
        tecnico.soporteTecnico();

        estudiantes_tecnicos.cargo();
        estudiantes_tecnicos.soporteTecnico();
    }
}
