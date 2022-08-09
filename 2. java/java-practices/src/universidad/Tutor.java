package universidad;

public class Tutor extends Estudiante implements Ayudante {
    @Override
    public void enseñar() {
        System.out.println("TUTOR: enseñando algo.");
    }
}
