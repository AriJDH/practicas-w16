package Animal;

public class Perro extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Guaaaauu");
    }

    @Override
    public void comerCarne() {
        Carnivoro.super.comerCarne();
    }



}
