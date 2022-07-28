package ejercicio3;

public class Gato implements Carnivoro,Animal{
    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }
}
