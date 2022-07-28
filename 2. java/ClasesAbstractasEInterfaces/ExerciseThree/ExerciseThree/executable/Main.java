package ExerciseThree.executable;

import ExerciseThree.actors.Gato;
import ExerciseThree.actors.Perro;
import ExerciseThree.actors.Vaca;

public class Main {
    public static void main(String args[]){
        Vaca v = new Vaca();
        v.emitirSonido("Muuuuu");
        v.comer();

        Gato g = new Gato();
        g.emitirSonido("Miau");
        g.comer();

        Perro p = new Perro();
        p.emitirSonido("Woof");
        p.comer();
    }
}
