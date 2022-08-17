import interfaces.ComerCarne;

public class Perro extends Animal implements ComerCarne {
    @Override
    public void emitirSonidos() {
        System.out.println("Guao Guao");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro es carnivoro");
    }
}
