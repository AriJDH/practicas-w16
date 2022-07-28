package ejercicio1;

public class Estudiante extends Persona {

    private Integer numeroDeLegajo;

    public Estudiante(Integer numeroDeLegajo) {
        this.numeroDeLegajo = numeroDeLegajo;
    }

    public Integer getNumeroDeLegajo(){
        return numeroDeLegajo;
    }

    @Override
    public String descripcion() {
        return "Estudiante";
    }

}
