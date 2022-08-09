package SeriesNumericas;

public class Tutor extends Estudiante implements IMiembroPersonal {
    @Override
    public void trabaja() {
        System.out.println("Explica");
    }

    public Tutor(Integer edad, String nombre) {
        super(edad, nombre);
    }
}
