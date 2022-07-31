package Animal;

public interface Carnivoro {

    default void comerCarne(){
        System.out.println("Comiendo carne");
    }

}
