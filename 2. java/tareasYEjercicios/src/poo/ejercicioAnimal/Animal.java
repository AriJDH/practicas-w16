package poo.ejercicioAnimal;

public abstract class Animal {

    public Animal() {
    }

    abstract void emitirSonido();

    abstract void comer();

    static void comerAnimal(Animal animal) {
        animal.comer();
    }

}
