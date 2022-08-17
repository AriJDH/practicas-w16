import interfaces.ComerHierba;

public class Vaca extends Animal implements ComerHierba {
    @Override
    public void emitirSonidos() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come Hierba");

    }
}
