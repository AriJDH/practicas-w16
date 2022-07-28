package Ejercicio3;

public interface Carnivoro {
    default void comerCarne(){
        System.out.println("Comiendo carne");
    }
}
