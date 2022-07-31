package Impresora;

import java.util.List;

public class Curriculum implements Imprimible{

    private String nombre;
    private String apellido;
    private String edad;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;

    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

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

    @Override
    public void imprimir() {
        System.out.println("IMPRIMIENDO CURRICULUM");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Edad: " + getEdad());
        System.out.println("Habilidades: " + getHabilidades());
        System.out.println("/////////////////////////////////");

    }
}
