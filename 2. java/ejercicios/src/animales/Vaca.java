package animales;

public class Vaca extends Animal implements Herviboro{

    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pasto...");
    }
}
