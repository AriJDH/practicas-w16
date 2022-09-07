package EjerciciosPracticosClasesAbstractasEInterfaces.SistemaCursos;



public class Main {
    public static void main(String[] args) {

        System.out.println("-----Profesor----");
        Profesor profesor = new Profesor("1234qw","Juan","Lopez","Matematicas");
        profesor.impartirCurso();

        System.out.println("-------Estudiante-------");
        Tutor tutor = new Tutor("akajs8","Tania","Mendez",7,"Introduccion a la programacion");
        tutor.impartirCurso();

        System.out.println("----Personal mantenimiento-----");
        Persona personalMantenimiento = new PersonalMantenimiento("qwe345","Luis","Suarez");
        System.out.println(personalMantenimiento.toString());

        System.out.println("----Miembro del Personal -----");
        Persona miembroPersonal = new MiembroPersonal("sd41q","Laura","Luna");
        System.out.println(miembroPersonal.toString());

        System.out.println("------Personal de soporte-------");
        PersonalSoporte soporte = new PersonalSoporte("aq094","Miguel","Hernandez");
        soporte.darSporte();

        System.out.println("-----Estudiante tecnico------");
        EstudianteTecnico estudianteTecnico = new EstudianteTecnico("lkadjdo4","Sonia","Villa",5);
        estudianteTecnico.darSporte();
    }
}
