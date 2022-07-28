package Ejercicio2;

public class Curriculum implements Documento {
    protected String nombre;
    protected String apellido;
    protected String habilidades;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    public Curriculum(){

    }

    public Curriculum(String nombre, String apellido, String habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }

    @Override
    public String infoDocumento() {
        return toString();
    }
}
