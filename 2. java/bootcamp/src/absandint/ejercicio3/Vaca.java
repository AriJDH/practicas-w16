package absandint.ejercicio3;

public class Vaca extends Animal implements Herviboro{

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("como hierba");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
