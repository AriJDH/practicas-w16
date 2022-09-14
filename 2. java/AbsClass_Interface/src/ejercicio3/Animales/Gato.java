package ejercicio3.Animales;

import ejercicio3.ClaseAbstracta.Animal;
import ejercicio3.Interfaces.Metodos;

public class Gato extends Animal implements Metodos {

    public Gato(String nombre, String especie) {
        super(nombre, especie);
    }

    @Override
    public String emitirSonido() {
        return "miau";
    }
}
