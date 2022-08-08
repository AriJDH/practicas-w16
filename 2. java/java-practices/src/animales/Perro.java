package animales;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        animal = null;
        System.out.println("El perro se comió un animal.");
    }
}
