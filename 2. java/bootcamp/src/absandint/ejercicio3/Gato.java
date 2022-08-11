package absandint.ejercicio3;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("como carne");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
