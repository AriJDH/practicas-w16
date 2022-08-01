package poo.ejercicioAnimal;

public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        Animal.comerAnimal(perro);
        perro.emitirSonido();

        Animal.comerAnimal(gato);
        gato.emitirSonido();

        Animal.comerAnimal(vaca);
        vaca.emitirSonido();

    }
}
