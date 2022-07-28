package Veterinaria;

public class Vaca extends Animal implements IHerviboro {

    @Override
    public void hacerSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca comio Hierba");
    }
}
