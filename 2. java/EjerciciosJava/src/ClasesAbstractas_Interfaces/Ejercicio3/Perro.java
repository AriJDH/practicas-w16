package ClasesAbstractas_Interfaces.Ejercicio3;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El perro se comio al animal porque es carnivoro");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}
