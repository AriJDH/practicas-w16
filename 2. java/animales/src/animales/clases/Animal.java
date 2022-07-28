package animales.clases;

import animales.interfaces.Carnivoro;
import animales.interfaces.Hervivoro;

public abstract class Animal {

    public static void comer(Animal animal) {
        if(animal instanceof Carnivoro)
            ((Carnivoro) animal).comerCarne();
        else if(animal instanceof Hervivoro)
            ((Hervivoro) animal).comerHierba();
        else
            System.out.println("El animal no pudo comer");
    }

    public abstract void emitirSonido();
}
