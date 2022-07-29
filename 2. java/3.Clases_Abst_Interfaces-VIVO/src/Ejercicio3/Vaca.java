package Ejercicio3;

public class Vaca extends Animal implements IHervivoro{
    public Vaca (String name) {
        super(name);
    }

    @Override
    void emitirSonido() {
        System.out.println("Muuuu Muuu Muu");;
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca almorzó hierba \n");
    }
}
