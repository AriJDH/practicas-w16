package Ejercicio1;

public class Estudiante extends Personas{
    Integer anio;

    public Estudiante(String nombre, Integer id, Integer anio) {
        super(nombre, id);
        this.anio = anio;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
