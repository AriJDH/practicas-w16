package Animal;

public class Vaca extends Animal implements Hervivoro{
    @Override
    void emitirSonido() {
        System.out.println("Muuuuu");
    }

}
