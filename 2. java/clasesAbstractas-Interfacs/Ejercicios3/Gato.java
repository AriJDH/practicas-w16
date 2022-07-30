package Ejercicios3;

public class Gato extends Animal{
    private boolean esCarnivoro = true;

    public boolean getEsCarnivoro() {
        return esCarnivoro;
    }
    public void emitirSonido() {
        System.out.println("Miau");
    }

    public Gato(boolean esCarnivoro) {
        this.esCarnivoro = esCarnivoro;
    }

    public Gato() {
    }
}
