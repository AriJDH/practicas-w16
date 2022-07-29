package clasesAbstractasEInterfacesVivo.ejercicioTres;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {

        System.out.println("muuuuu");
    }

    @Override
    public void comerHierba() {

        System.out.println("La vaca esta comiendo hierba");
    }
}
