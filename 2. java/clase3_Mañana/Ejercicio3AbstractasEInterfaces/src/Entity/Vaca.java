package Entity;

import Interface.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("muu muu muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Yo como hierbas porque soy una vaca");
    }
}
