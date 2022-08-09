package SeriesNumericas;

public class SoporteTecnico extends Estudiante implements  IMiembroPersonal {
    @Override
    public void trabaja() {
        System.out.println("soporte");
    }

    public SoporteTecnico(Integer edad, String nombre) {
        super(edad, nombre);
    }
}
