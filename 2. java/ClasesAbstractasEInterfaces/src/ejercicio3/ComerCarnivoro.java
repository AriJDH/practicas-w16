package ejercicio3;

public class ComerCarnivoro extends Comer{


    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comer carne");
    }
}
