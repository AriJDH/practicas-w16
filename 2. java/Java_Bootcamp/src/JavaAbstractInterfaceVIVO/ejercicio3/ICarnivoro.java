package JavaAbstractInterfaceVIVO.ejercicio3;

public interface ICarnivoro {
    void comerCarne();

    default void comerAnimal(ICarnivoro carnivoro) {
        System.out.println("> > A comido animal");
    }
}
