package ExerciseThree.actors;
import ExerciseThree.interfaces.Alimentable;
import ExerciseThree.interfaces.Sonido;

public abstract class Animal implements Sonido, Alimentable {
    
    @Override
    public void emitirSonido(String sonido) {
        System.out.println(sonido);
    }
}