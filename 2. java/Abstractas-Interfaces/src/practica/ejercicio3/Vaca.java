package practica.ejercicio3;

public class Vaca extends Animal implements Hervivoro{
    @Override
    public void emitirSonido() {
        System.out.println("MUUUUU");
    }

    @Override
    public void comerHierva() {
        System.out.println("Comiendo plantas como una vaquita");
    }
}
