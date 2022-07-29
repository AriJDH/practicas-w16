package Ejercicio3;

public class Perro extends Animal implements ICarnivoro{
    public Perro(String name) {
        super(name);
    }

    @Override
    void emitirSonido() {
        System.out.println("Gua Gua Gua Gua");;
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro almorzó carne \n");
    }
}
