package JavaAbstractInterfaceVIVO.ejercicio3;

public class Vaca extends Animales implements IHerbivoro {

    @Override
    public void producirSonido() {
        System.out.println("MUUUU !!!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come Pasto");
    }
}
