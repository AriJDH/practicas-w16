package main;

public class Vaca extends Animal implements AlimentacionDeUnHerviboro{
    public Vaca() {}
    @Override
    public void hacerSonido() {
        System.out.printf("Muu");
    }
    @Override
    public void comerHierba() {
        System.out.printf("Comiendo vegetales");

    }
}
