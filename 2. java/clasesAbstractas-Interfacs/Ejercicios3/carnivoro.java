package Ejercicios3;

public interface carnivoro {

    default void comerCarne() {
        System.out.println("Comiendo carne");
    }

}
