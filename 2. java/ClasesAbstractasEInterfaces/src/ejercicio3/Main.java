package ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Guau","carnivoro");
        Gato gato = new Gato("Miau","carnivoro");
        Vaca vaca = new Vaca("Muuu","hervivoro");

        perro.emitirSonido();
        perro.comerCarne();

        gato.emitirSonido();
        gato.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();

        perro.comerAnimal(perro.getEspecie());
    }
}
