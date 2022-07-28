package ejercicio3;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu.");
    }

    @Override
    public void comerAnimal() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba siendo vaca.");
    }
}
