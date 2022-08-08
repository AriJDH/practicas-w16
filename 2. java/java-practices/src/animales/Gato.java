package animales;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        animal = null;
        System.out.println("El gato se comió un animal.");
    }
}
