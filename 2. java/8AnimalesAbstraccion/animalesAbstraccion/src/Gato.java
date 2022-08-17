import interfaces.ComerCarne;

public class Gato extends Animal implements ComerCarne {

    @Override
    public void emitirSonidos() {
        System.out.println("Miauuu");

    }

    @Override
    public void comerCarne() {
        System.out.println("El gato es Carnívoro");
    }
}
