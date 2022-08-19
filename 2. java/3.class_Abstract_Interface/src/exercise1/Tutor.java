package exercise1;


public class Tutor extends Estudiante implements IEnsenable{

    @Override
    public void ensenarAOtros() {
        System.out.println("Estudiantes ensenan algo a otros");
    }
}
