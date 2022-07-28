package main.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculums implements Imprimir{
    private Persona unaPersona;
    List<String> habilidades = new ArrayList<>();

    public Curriculums(Persona unaPersona, List<String> habilidades) {
        this.unaPersona = unaPersona;
        this.habilidades = habilidades;
    }
    @Override
    public String toString() {
        return "Curriculums{" +
                "persona =" + unaPersona.toString() +
                ", sus habilidades son =" + habilidades.toString() +
                "}";
    }

    @Override
    public void imprimirDocumento() {
        System.out.printf(this.toString());

    }
}
