package ejercicioTres.animales;

import ejercicioTres.interfaces.Animal;
import ejercicioTres.interfaces.Carnivoro;

public class Perro implements Animal, Carnivoro {

    @Override
    public void haceSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo Carne");
    }
}
