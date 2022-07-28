package ClasesAbstractas_Interfaces.Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El gato se comio al animal porque es carnivoro");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}
