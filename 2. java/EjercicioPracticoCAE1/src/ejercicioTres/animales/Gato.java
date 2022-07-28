package ejercicioTres.animales;

import ejercicioTres.interfaces.Animal;
import ejercicioTres.interfaces.Carnivoro;

public class Gato implements Animal, Carnivoro {
    @Override
    public void haceSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
