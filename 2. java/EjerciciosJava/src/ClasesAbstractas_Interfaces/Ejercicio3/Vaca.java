package ClasesAbstractas_Interfaces.Ejercicio3;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("La vaca no se comio al animal porque es hervibora");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
