package JavaAbstractInterfaceVIVO.ejercicio3;

public class Perro extends Animales implements ICarnivoro {

    @Override
    public void producirSonido() {
        System.out.println("GUAA UUUU !!!");
    }

    @Override
    public void comerCarne() {
        System.out.println("comer carne ");
    }

    @Override
    public void comerAnimal(ICarnivoro carnivoro) {
        ICarnivoro.super.comerAnimal(carnivoro);
    }
}
