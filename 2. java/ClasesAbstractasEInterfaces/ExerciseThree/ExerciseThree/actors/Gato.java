package ExerciseThree.actors;

import ExerciseThree.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    
    public Gato() {
        super();
    }
    
    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne");
    }
    
    @Override
    public void emitirSonido(String sonido) {
        System.out.println(sonido);
    }
    
    @Override
    public void comer() {
        comerCarne();
    }
}
