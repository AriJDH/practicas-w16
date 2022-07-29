package Ejercicio3;

public class Gato extends Animal implements ICarnivoro{
    public Gato (String name) {
        super(name);
    }

    @Override
    void emitirSonido() {
        System.out.println("Miau Miau Miau Miau");;
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato almorzó carne  \n");
    }
}
