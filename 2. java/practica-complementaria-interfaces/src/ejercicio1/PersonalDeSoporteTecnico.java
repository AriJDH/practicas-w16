package ejercicio1;

public class PersonalDeSoporteTecnico extends Persona implements Tecnico {
    @Override
    public void reparar() {
        // "Do something."
    }

    @Override
    String descripcion() {
        return "Personal de soporte tecnico";
    }
}
