package ClasesAbstractasEInterfaces.Ejercicio3;

public class Vaca extends Animal {
    @Override
    void emitirSonido(){
        System.out.println("Moo");
    }
    @Override
    void comerCarne(){
        System.out.println("Soy herviboro, no como carne.");
    }
    @Override
    void comerHierbas(){
        System.out.println("Soy herviboro, como hierbas");
    }
}
