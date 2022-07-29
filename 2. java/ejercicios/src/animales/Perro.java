package animales;

public class Perro extends Animal implements Carnivoro{


    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }
}
