package ExerciseThree;

public class Cow extends Animal implements Herbivorous{
    @Override
    public void eatPlants() {
        System.out.println("La vaca come hierba");
    }
}
