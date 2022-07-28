package animales.interfaces;

public interface Carnivoro {

    default void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
