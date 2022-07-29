package practicesInterfaceAbstract3;

public abstract class Animal {

    private String sound;
    private String kindOfAnimal;

    public Animal(String sound, String kindOfAnimal) {
        this.sound = sound;
        this.kindOfAnimal = kindOfAnimal;
    }

    public Animal() {
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public abstract void emitSound();
}
