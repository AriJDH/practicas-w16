package ExerciseTwo.interfaces;

import ExerciseTwo.actors.Documento;

public interface Imprimible {
    public static void imprimir(Documento documento) {
        System.out.println(documento);
    }
}
