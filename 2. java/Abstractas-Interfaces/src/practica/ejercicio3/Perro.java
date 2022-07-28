package practica.ejercicio3;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("GUAUUUU");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne como un perrito");
    }
}
