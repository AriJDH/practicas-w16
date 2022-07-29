package Ejercicio2;

import java.util.List;

public class Curriculum implements IDocumento {
    private Persona unaPersona;
    List<String> skills;

    public Curriculum(Persona unaPersona, List<String> skills) {
        this.unaPersona = unaPersona;
        this.skills = skills;
    }

    @Override
    public String toString(){
        return "----Informacion de la CV:\n " +
                unaPersona.toString() + " \n" +
                "-- Habilidades: " + skills.toString() + " \n";
    }
}
