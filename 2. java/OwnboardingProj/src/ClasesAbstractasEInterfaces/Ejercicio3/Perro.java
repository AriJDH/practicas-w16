package ClasesAbstractasEInterfaces.Ejercicio3;

public class Perro extends Animal{
    @Override
    void emitirSonido(){
        System.out.println("Woof");
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
