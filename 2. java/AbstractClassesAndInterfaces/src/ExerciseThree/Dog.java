package ExerciseThree;

public class Dog extends Animal implements Carnivorous {
    @Override
    public void eatMeat() {
        System.out.println("El perro come carne");
    }
}
