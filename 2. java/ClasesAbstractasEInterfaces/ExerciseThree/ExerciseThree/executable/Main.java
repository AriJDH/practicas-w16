package ExerciseThree.executable;

import ExerciseThree.actors.Gato;
import ExerciseThree.actors.Perro;
import ExerciseThree.actors.Vaca;
import ExerciseThree.interfaces.Alimentable;

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

        System.out.println("\n Testing Alimentable interface");
        Alimentable.comerAnimal(v);
        Alimentable.comerAnimal(p);
        Alimentable.comerAnimal(g);
    }
}
