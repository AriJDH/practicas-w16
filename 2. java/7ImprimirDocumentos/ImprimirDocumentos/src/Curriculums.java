package Ejercicio2;

import java.util.List;

public class Curriculums  implements Imprimible {
    private String nombre;
    private List<String> habilidades;

    public Curriculums() {
    }

    public Curriculums(String nombre, List<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimible() {
        System.out.println("Hola imprimiendo Curriculums de : " + this.nombre + " con las habilidades siguientes : " + this.habilidades);
    }
}
