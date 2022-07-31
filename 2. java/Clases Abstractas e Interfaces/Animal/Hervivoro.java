package Animal;

public interface Hervivoro {

    default void comerHierba(){
        System.out.println("Comiendo hierba");
    }
}
