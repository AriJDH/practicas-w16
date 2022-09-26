package ejercicio3;

public class Main {
  public static void main(String[] args) {

    Perro perro = new Perro();
    Vaca vaca = new Vaca();
    Gato gato = new Gato();
    //call methods
    perro.comerCarne();
    perro.emitirSonido();
    vaca.comerHierba();
    vaca.emitirSonido();
    gato.comerCarne();
    gato.emitirSonido();

    Carnivoro.ComerAnimal(gato);
    Carnivoro.ComerAnimal(vaca);
    Carnivoro.ComerAnimal(perro);
  }
}


