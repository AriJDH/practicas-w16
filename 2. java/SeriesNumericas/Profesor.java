package SeriesNumericas;

public class Profesor extends Persona implements IMiembroPersonal {
    public Profesor(Integer edad, String nombre) {
        super(edad, nombre);
    }

    @Override
    public void trabaja() {
        System.out.println("dando clases");
    }
}
