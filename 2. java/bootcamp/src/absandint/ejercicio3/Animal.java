package absandint.ejercicio3;

public abstract class Animal {

    public abstract void emitirSonido();
    public abstract void comer();

    public static void comerAnimal(Animal a){
        a.comer();
    }
}
