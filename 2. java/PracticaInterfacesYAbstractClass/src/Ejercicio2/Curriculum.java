package Ejercicio2;

import java.util.List;

public class Curriculum implements Imprimible{

    private String nombre;
    private int edad;
    private List<String> habilidades;

    public Curriculum(String nombre, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Curriculum:");
        System.out.println(this.toString());
    }
}
