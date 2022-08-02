package ejercicio3;

public class Gato extends Animal implements Carnivoro{

    public Gato(String sonido, String especie) {
        super(sonido, especie);
    }

    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println(this.getSonido());
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne");
    }
}
