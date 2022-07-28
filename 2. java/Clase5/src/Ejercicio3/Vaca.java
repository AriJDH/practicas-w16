package Ejercicio3;

public class Vaca extends Animal implements Herbivoro{

    @Override
    public String EmitirSonido() {
        return "Moo";
    }

    @Override
    public String comerHierba() {
        return "3men2 pastito.";
    }
}
