package ejercicio1;

public class Profesor extends Persona implements Capacitador {
    @Override
    public void enseñar() {
        // "Do something."
    }

    @Override
    String descripcion() {
        return "Profesor";
    }
}
