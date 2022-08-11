package absandint.ejercicio3;

public class Main {

    public static void main(String[] args) {
        Animal perro = new Perro();
        perro.emitirSonido();
        Animal.comerAnimal(perro);

        Animal vaca = new Vaca();
        vaca.emitirSonido();
        Animal.comerAnimal(vaca);

        Animal gato = new Gato();
        gato.emitirSonido();
        Animal.comerAnimal(gato);

    }
}
