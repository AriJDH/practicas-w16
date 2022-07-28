package ejercicio3;

public class Vaca extends Animal implements  Hervivoro{

    @Override
    public void emitirSonido() {
        System.out.println("mu");
    }

    @Override
    public void comerHierba() {
        System.out.println("comiendo pasto");
    }
}
