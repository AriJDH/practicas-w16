package Ejercicios3;

public class Vaca extends Animal{

    private boolean esCarnivoro = false;

    public boolean getEsCarnivoro() {
        return esCarnivoro;
    }

    public void emitirSonido() {
        System.out.println("Muuu");
    }

    public Vaca(boolean esCarnivoro) {
        this.esCarnivoro = esCarnivoro;
    }

    public Vaca() {
    }

}
