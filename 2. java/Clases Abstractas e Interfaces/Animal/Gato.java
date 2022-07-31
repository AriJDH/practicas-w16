package Animal;

public class Gato extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Miauuuuu");
    }

    @Override
    public void comerCarne() {
        Carnivoro.super.comerCarne();
    }


}
