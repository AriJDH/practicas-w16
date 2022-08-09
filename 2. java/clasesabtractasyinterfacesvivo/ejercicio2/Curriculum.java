package ejercicio2;

import java.util.Arrays;

public class Curriculum {

        private String nombre;
        private String apellido;
        private int edad;
        private String[] habilidades;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPellido() {
        return this.apellido;
    }

    public void setPellido(String pellido) {
        this.apellido = pellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String[] getHabilidades() {
        return this.habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public Curriculum(String nombre, String pellido, int edad, String... habilidades) {
        this.nombre = nombre;
        this.apellido = pellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", pellido='" + apellido + '\'' +
                ", edad='" + edad + '\'' +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}';
    }
}
