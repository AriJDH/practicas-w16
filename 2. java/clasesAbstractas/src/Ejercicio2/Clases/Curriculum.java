package Ejercicio2.Clases;

import Ejercicio2.Interfaz.Imprimible;

import java.util.List;

public class Curriculum extends Persona implements Imprimible {
private List<String> habilidades;

    public Curriculum(String name, String surname, String email, int age, List<String> habilidades) {
        super(name, surname, email, age);
        this.habilidades = habilidades;
    }

    public Curriculum() {}

    @Override
    public String toString() {
        return "Curriculum{" +
                "habilidades=" + habilidades +
                '}';
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimible() {
        System.out.println("Los Datos del Curriculum de la persona son: \n" +
                getName() +
                ", " + getSurname() + ", " + getEmail() + ", " + getAge() + ", " +
                "\nesta una lista de habilidades de la persona:");
        for(String habilidad : this.habilidades){
            System.out.println(habilidad);
        }

    }
}
