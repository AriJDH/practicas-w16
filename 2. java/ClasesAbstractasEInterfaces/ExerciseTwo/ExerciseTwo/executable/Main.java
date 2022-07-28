package ExerciseTwo.executable;

import java.util.List;
import java.util.ArrayList;

import ExerciseTwo.actors.*;
import ExerciseTwo.interfaces.Imprimible;

public class Main {
    public static void main(String args[]){
        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("C#");
        skills.add("Python");

        Persona persona = new Persona("Juan", "Perez", skills);
        Curriculum curriculum = new Curriculum(persona);
        Imprimible.imprimir(curriculum);
        
        LibroPDF libro = new LibroPDF(450, "Haskell Curry", "Haskell", "Programming");
        Imprimible.imprimir(libro);

        StringBuffer texto = new StringBuffer("Informe de Java");
        Informe informe = new Informe(texto, 12, "Juan Prieto", "Santiago Cano");
        Imprimible.imprimir(informe);
    }
}
