package Ejercicio1;

import java.util.ArrayList;

public interface Academico {
    static void ensenar(ArrayList<String> cursos) {
        System.out.println("Enseñando en cursos:\n" + cursos);
    }
}
