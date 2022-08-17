package ExerciseThree;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.eatMeat();
        dog.makeSound("El perro hace guau");

        Cat cat = new Cat();

        cat.eatMeat();
        cat.makeSound("El gato hace miau");

        Cow cow = new Cow();
        cow.eatPlants();
        cow.makeSound("La vaca hace muu");
    }
}
