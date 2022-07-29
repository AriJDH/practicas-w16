package practicesInterfaceAbstract3;

public class Cat extends Animal implements Carnivorous {

    public Cat(String sound, String kindOfAnimal) {
        super(sound, kindOfAnimal);
    }

    public Cat() {
    }

    @Override
    public void emitSound() {
        System.out.println(this.getSound());
    }

    @Override
    public void eatMeat() {
        System.out.println("El gato está comiendo carne");
    }
}
