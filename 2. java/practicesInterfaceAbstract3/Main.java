package practicesInterfaceAbstract3;

public class Main {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("Guau", "Carnivorous");
        Cat cat = new Cat("Miau", "Carnivorous");
        Cow cow = new Cow("Muuu", "Herbivorous");
        Eat eat = new Eat<Animal>();

        dog.emitSound();
        dog.eatMeat();

        cat.emitSound();
        cat.eatMeat();

        cow.emitSound();
        cow.eatGrass();

        System.out.println("------------------------");

        eat.eatAnimal(cow);
        eat.eatAnimal(dog);
    }
}
