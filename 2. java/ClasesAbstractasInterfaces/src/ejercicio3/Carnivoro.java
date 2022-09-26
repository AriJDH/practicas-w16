package ejercicio3;

public interface Carnivoro<T> {

  void comerCarne();

  static <T> void ComerAnimal(T animal) {
    System.out.println(animal.getClass().getSimpleName() + " Comiendo Animal");
  }
}
