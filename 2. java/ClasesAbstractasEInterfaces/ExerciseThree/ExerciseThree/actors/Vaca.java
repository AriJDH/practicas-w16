package ExerciseThree.actors;

import ExerciseThree.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro{
    
    public Vaca() {
        super();
    }
    
    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }
    
    @Override
    public void emitirSonido(String sonido) {
        System.out.println(sonido);
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
