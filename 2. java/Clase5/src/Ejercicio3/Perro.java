package Ejercicio3;

public class Perro extends Animal implements Carnivoro{

    @Override
    public String EmitirSonido() {
        return "Guau";
    }

    @Override
    public String comerCarne() {
        return "3men2 bistek.";
    }
}
