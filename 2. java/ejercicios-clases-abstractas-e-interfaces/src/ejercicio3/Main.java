package ejercicio3;

public class Main {

    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        perro.comerAnimal();
        gato.comerAnimal();
        vaca.comerAnimal();
    }

}
