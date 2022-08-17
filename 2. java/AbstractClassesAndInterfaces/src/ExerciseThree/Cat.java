package ExerciseThree;

public class Cat extends Animal implements Carnivorous {
    @Override
    public void eatMeat() {
        System.out.println("El gato come carne");
    }
}
