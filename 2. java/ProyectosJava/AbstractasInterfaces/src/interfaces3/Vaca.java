package abstractasInterfases.interfaces3;

public class Vaca extends Animal implements Herbivoro{


    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("comiendo el pasto");

    }
}
