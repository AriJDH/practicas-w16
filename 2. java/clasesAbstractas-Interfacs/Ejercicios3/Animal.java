package Ejercicios3;

public abstract class Animal implements carnivoro, herviboro {

    public abstract void emitirSonido();

    public void comerAnimal(boolean esCarnivoro) {
        if(esCarnivoro){
            comerCarne();
        } else {
            comerHierba();
        }
    }
}
