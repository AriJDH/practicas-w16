package poo.ejercicioAnimal;

public class Vaca extends Animal implements Herviboro {

    @Override
    void emitirSonido() {
        System.out.println("Muu muuu");
    }

    @Override
    void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca comiendo pasto");
    }
}
