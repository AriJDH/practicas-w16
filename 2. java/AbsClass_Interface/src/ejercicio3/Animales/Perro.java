package ejercicio3.Animales;

import ejercicio3.ClaseAbstracta.Animal;
import ejercicio3.Interfaces.Metodos;

public class Perro extends Animal implements Metodos {

    public Perro(String nombre, String especie) {
        super(nombre, especie);
    }

    @Override
    public String emitirSonido() {
        return "guau";
    }
}
