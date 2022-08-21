package JavaAbstractInterfaceVIVO.ejercicio3;

public class Gato extends Animales implements ICarnivoro {

    @Override
    public void producirSonido() {
        System.out.println("MIA UUUUU !!!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }

    @Override
    public void comerAnimal(ICarnivoro carnivoro) {
        ICarnivoro.super.comerAnimal(carnivoro);
    }
}
