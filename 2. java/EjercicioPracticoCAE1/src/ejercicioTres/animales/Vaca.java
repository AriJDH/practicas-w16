package ejercicioTres.animales;

import ejercicioTres.interfaces.Animal;
import ejercicioTres.interfaces.Herbivoro;

public class Vaca implements Animal, Herbivoro {
    @Override
    public void haceSonido() {
        System.out.println("muuuu");
    }

    @Override
    public void comerHierva() {
        System.out.println("Comiendo Hierva");
    }
}
