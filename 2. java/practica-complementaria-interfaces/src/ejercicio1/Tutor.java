package ejercicio1;

public class Tutor extends Estudiante implements Capacitador {
    public Tutor(Integer numeroDeLegajo) {
        super(numeroDeLegajo);
    }

    @Override
    public String descripcion() {
        return "Estudiante y tutor";
    }

    @Override
    public void enseñar() {
        // "Do something."
    }
}
