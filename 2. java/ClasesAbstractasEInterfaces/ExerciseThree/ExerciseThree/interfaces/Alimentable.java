package ExerciseThree.interfaces;

import ExerciseThree.actors.Animal;

public interface Alimentable {
    public static void comerAnimal(Animal animal) {
        animal.comer();
    }

    public abstract void comer();
}
