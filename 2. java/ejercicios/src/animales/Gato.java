package animales;

public class Gato extends Animal implements Carnivoro{

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }
}
