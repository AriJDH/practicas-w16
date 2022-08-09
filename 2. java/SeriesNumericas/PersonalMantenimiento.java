package SeriesNumericas;

public class PersonalMantenimiento extends Persona implements IMiembroPersonal {
    @Override
    public void trabaja() {
        System.out.println("mantiene");
    }

    public PersonalMantenimiento(Integer edad, String nombre) {
        super(edad, nombre);
    }
}
