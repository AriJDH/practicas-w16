package practica.clasesabstractaseinterfaces.ejercicio2;

import java.util.ArrayList;

public class Curriculum implements Imprimible {
    protected ArrayList<String> atributos;
    protected ArrayList<String> habilidades;

    public Curriculum(ArrayList<String> atributos, ArrayList<String> habilidades) {
        this.atributos = atributos;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "atributos=" + atributos +
                ", habilidades=" + habilidades +
                '}';
    }
}
