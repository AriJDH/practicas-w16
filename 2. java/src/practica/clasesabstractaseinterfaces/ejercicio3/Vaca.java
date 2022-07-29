package practica.clasesabstractaseinterfaces.ejercicio3;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pasto");
    }
}
