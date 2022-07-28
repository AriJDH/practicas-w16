package ExerciseThree.actors;

import ExerciseThree.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    
    public Perro() {
        super();
    }
    
    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne");
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