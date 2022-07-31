package animales.clases;

public abstract class Animal {

    public abstract void emitirSonidos();

    public void comerAnimal(Object animal) {
        if (animal instanceof Perro) {
            Perro p = (Perro)animal;
            p.comerCarne();
        }
        else if (animal instanceof Gato) {
            Gato g = (Gato)animal;
            g.comerCarne();
        }
        else if (animal instanceof Vaca) {
            Vaca v = (Vaca)animal;
            v.comerHierba();
        }
    }
}
