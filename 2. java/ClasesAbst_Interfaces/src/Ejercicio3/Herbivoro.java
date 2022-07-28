package Ejercicio3;

public interface Herbivoro {
    default void comerHierba(){
        System.out.println("Comiendo hierba");
    }
}
