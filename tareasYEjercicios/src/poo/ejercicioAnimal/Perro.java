package poo.ejercicioAnimal;

public class Perro extends Animal implements Carnivoro {

    @Override
    void emitirSonido() {
        System.out.println("Guau guau");
    }

    @Override
    void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro comiendo carne");
    }
}
