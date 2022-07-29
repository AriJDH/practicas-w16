package practicesInterfaceAbstract3;

public class Cow extends Animal implements Herbivorous {

    public Cow(String sound, String kindOfAnimal) {
        super(sound, kindOfAnimal);
    }

    public Cow() {
    }

    @Override
    public void emitSound() {
        System.out.println(this.getSound());
    }

    @Override
    public void eatGrass() {
        System.out.println("La vaca está comiendo hierba");
    }
}
