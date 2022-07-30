package Ejercicios3;

public class Perro extends Animal{

    private boolean esCarnivoro = true;

    public boolean getEsCarnivoro() {
        return esCarnivoro;
    }

    public Perro(boolean esCarnivoro) {
        this.esCarnivoro = esCarnivoro;
    }

    public Perro() {
    }

    public void emitirSonido() {
        System.out.println("Guau");
    }

}
