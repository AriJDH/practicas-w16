package practica.ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("MIAUUUU");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne como un gatito");
    }
}
