package ClasesAbstractasEInterfaces.Ejercicio3;

public class Gato extends Animal {
    @Override
    void emitirSonido(){
        System.out.println("Meow");
    }
    @Override
    void comerCarne(){
        System.out.println("Soy carnivoro, como carne.");
    }
    @Override
    void comerHierbas(){
        System.out.println("Soy carnivoro, no como hierbas");
    }
}
