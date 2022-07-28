package ejercicio1;

public class EstudianteTecnico extends Estudiante implements Tecnico {

    public EstudianteTecnico(Integer numeroDeLegajo) {
        super(numeroDeLegajo);
    }

    @Override
    public String descripcion() {
        return "Estudiante y tecnico";
    }

    @Override
    public void reparar() {
        // "Do something."
    }
}
