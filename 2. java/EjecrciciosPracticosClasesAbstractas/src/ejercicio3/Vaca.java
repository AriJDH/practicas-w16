package ejercicio3;

public class Vaca implements Herviboro,Animal{
    @Override
    public void comerHierva() {
        System.out.println("Comiendo hierva");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }
}
