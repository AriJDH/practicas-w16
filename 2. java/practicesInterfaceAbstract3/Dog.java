package practicesInterfaceAbstract3;

public class Dog extends Animal implements Carnivorous {

    public Dog(String sound, String kindOfAnimal) {
        super(sound, kindOfAnimal);
    }

    public Dog() {
    }

    @Override
    public void emitSound() {
        System.out.println(this.getSound());
    }

    @Override
    public void eatMeat() {
        System.out.println("El perro está comiendo carne");
    }
}
